(function (factory) {
    "use strict";
    factory(window.jQuery);
}(function ($) {
    "use strict";

    var isIE, hasFileAPISupport, hasFileUploadSupport, getNum, handler, isEmpty, uniqId, getExtension, getFileSize, isPic, compare, CscecFile;
    isIE = function (ver) {
        if (navigator.appName !== 'Microsoft Internet Explorer') {
            return false;
        }
        if (ver === 10) {
            return new RegExp('msie\\s' + ver, 'i').test(navigator.userAgent);
        }
        var div = document.createElement("div"), status;
        div.innerHTML = "<!--[if IE " + ver + "]> <i></i> <![endif]-->";
        status = div.getElementsByTagName("i").length;
        document.body.appendChild(div);
        div.parentNode.removeChild(div);
        return status;
    };
    hasFileAPISupport = function () {
        return !!(window.File && window.FileReader);
    };
    hasFileUploadSupport = function () {
        return hasFileAPISupport() && window.FormData;
    };
    getNum = function (num, def) {
        def = def || 0;
        if (typeof num === "number") {
            return num;
        }
        if (typeof num === "string") {
            num = parseFloat(num);
        }
        return isNaN(num) ? def : num;
    };
    handler = function ($el, event, callback) {
        $el.off(event).on(event, callback);
    };
    isEmpty = function (value, trim) {
        return value === undefined || value === null || value.length === 0 || (trim && $.trim(value) === '');
    };
    uniqId = function () {
        return Math.round(new Date().getTime() + (Math.random() * 100));
    };
    getExtension = function (filename) {
        return filename.substring(filename.lastIndexOf(".") + 1, filename.length);
    };
    getFileSize = function (size) {
        if (size < 1024) {
            return size + "B";
        }
        else if (size < 1024 * 1024) {
            return (parseFloat(size) / parseFloat(1024)).toFixed(2) + "KB";
        }
        else {
            return (parseFloat(size) / parseFloat(1024 * 1024)).toFixed(2) + "MB";
        }
    };
    isPic = function (file) {

        if (typeof file === "string")
            return compare(file, 'image.*') || compare(file, /\.(gif|png|jpe?g)$/i);
        return compare(file.name, 'image.*') || compare(file.name, /\.(gif|png|jpe?g)$/i);
    };
    compare = function (input, str, exact) {
        return input !== undefined && (exact ? input === str : input.match(str));
    };

    CscecFile = function (element, options) {
        var self = this;
        self.$element = $(element);
        if (!self._validate()) {
            return;
        }
        self.isPreviewable = hasFileAPISupport();
        self.isIE9 = isIE(9);
        self.isIE10 = isIE(10);
        if (self.isPreviewable || self.isIE9) {
            self._init(options);
        }
        else {
            self.$element.removeClass('file-loading');
        }
    };
    CscecFile.prototype = {
        constructor: CscecFile,
        _init: function (options) {
            var self = this, $el = self.$element, t;
            $.each(options, function (key, value) {
                switch (key) {
                    case 'minFileCount':
                    case 'maxFileCount':
                    case 'maxFileSize':
                        self[key] = getNum(value);
                        break;
                    default:
                        self[key] = value;
                        break;
                }
            });
            self.uploadFileAttr = !isEmpty($el.attr('name')) ? $el.attr('name') : 'file_data';
            self.reader = new FileReader();
            self.reader.onloadend = self._readComplete;
            self.reader.self = self;
            self.formdata = new FormData();
            self.delFile = [];
            self.filecount = 0;
            self.package = null;
            self.list = null;
            self._render();
            self._initEvent();
            self._initExtension();
            self.filerecord = 0;
            self.tempObj = null;
        },
        _validate: function () {
            var self = this, $exception;
            if (self.$element.attr('type') === 'file') {
                return true;
            }
            $exception = '<div class="alert alert-warning">' +
                '<h4>类型错误</h4>' +
                '初始化的标记必须是<code>type = file</code>' +
                '</div>';
            self.$element.after($exception);
            return false;
        },
        _fileValidate: function (file) {
            var self = this, extension, num = 0;
            extension = getExtension(file.name);
            if (!self.extensionArr || self.extensionArr.length == 0) return true;
            $.each(self.extensionArr, function (index, obj) {
                if (extension.toLowerCase() === obj.toLowerCase()) {
                    num++;
                    return;
                }
            });
            if (num > 0) {
                return true;
            }
            self._setTooltip($("<i class=\"glyphicon glyphicon-exclamation-sign\"></i> <span>上传的文件类型必须是：" + self.extension + "</span>"), "text-danger");
            return false;
        },
        _fileNoneValidate: function () {
            var self = this;
            if (self.filerecord == 0) {
                self._setTooltip($("<i class=\"glyphicon glyphicon-remove-sign\"></i> <span>还没有选择上传的文件！</span>"), "text-danger");
                return false;
            }
            return true;
        },
        _fileMaxValidate: function () {
            var self = this;
            if (self.maxFileCount <= self.filecount) {
                self._setTooltip($("<i class=\"glyphicon glyphicon-ban-circle\"></i> <span>只能上传" + self.maxFileCount + "个文件！</span>"), "text-danger");
                return false;
            }
            return true;
        },
        _fileMinValidate: function () {
            return self.minFileCount > self.filecount
        },
        _initExtension: function () {
            var self = this;
            if (!self.extension) return;
            self.extensionArr = self.extension.split(',');
        },
        _addFile: function (obj) {
            var self = this, file = $(self.file), fileSign = $(self.fileSign), fileDescription = $(self.fileDescription), fileSize = $(self.fileSize), fileRemove = $(self.fileRemove);

            file.attr("id", obj.id);
            if (obj.num > -1) file.attr("data-num", obj.num);
            if (obj.type) file.attr("data-type", obj.type);
            file.append(fileSign).append(fileDescription).append(fileSize).append(fileRemove);
            fileSign.find("img").attr("src", obj.url);
            fileDescription.find(".file_note").text(obj.filename);
            fileSize.find(".file_note").text(getFileSize(obj.filesize));
            self.filecount++;
            self.list.append(file);
        },
        _loadFile: function () {
            var self = this, url;
            if (!self._fileMaxValidate()) return;
            var file = self.$element.get(0).files[0];
            if (!file) return;
            if (!self._fileValidate(file)) return;
            var num = self.filerecord++;
            var id = self.uploadFileAttr + "_" + num;
            self.formdata.append(id, file);
            self.tempObj = { id: id, num: num, filename: file.name, filesize: file.size, type: "new" };

            if (!isPic(file)) {
                self.tempObj.url = self.unkownFileUrl;
                self._addFile(self.tempObj);
            }
            else {
                self.reader.readAsDataURL(file);
            }
        },
        _readComplete: function () {
            var self = this.self;
            self.tempObj.url = this.result;
            self._addFile(self.tempObj);
        },
        _delFile: function (obj) {
            var self = this;
            var file = $(obj).closest(".file_attachment");
            if (file.data("type") == "new")
                self.formdata.delete(file.attr("id"));
            else
                self.delFile.push(file.attr("id"));
            self.filecount--;
            file.remove();
        },
        _uploadFile: function () {
            var self = this, settings;
            self.formdata.append(self.uploadFileAttr, self.uploadFileAttr);
            settings = $.extend(true, {}, {
                url: self.url,
                type: "post",
                dataType: "json",
                data: self.formdata,
                processData: false,
                contentType: false,
                beforeSend: function (jqXHR) {

                },
                success: function (data, textStatus, jqXHR) {
                    self._setTooltip($("<i class='glyphicon glyphicon-ok'></i> <span>上传成功</span>"), "text-success");
                    self._uploadComplete();
                },
                error: function (jqHXR, textStatus, errorThrown) {

                }
            });
            $.ajax(settings);
        },
        _analysisFormData: function () {
            var self = this, keys = self.formdata.keys(), key, obj = {};
            while (!(key = keys.next()).done) {
                obj[key.value] = self.formdata.get(key.value);
            }
            return obj;
        },
        _uploadComplete: function () {
            var self = this;
            self.formdata = new FormData();
            self.filerecord = 0;
            self.list.find("[data-type='new']").removeAttr("data-num").removeAttr("data-type");
        },
        _setTooltip: function (obj, cls) {
            var self = this;
            self.noteTag.attr("class", "").addClass(cls).text("").append(obj);
        },
        _initEvent: function () {
            var self = this;
            self.package
            .on("mouseenter", ".file_remove .glyphicon", function () {
                if ($.fn.tooltip)
                    $(this).tooltip();
            })
            .on("click", ".file_remove .glyphicon", function () {
                self._delFile(this);
            })
            .on("click", "button.btn-upload", function () {
                if (!self._fileNoneValidate()) return false;
                self._uploadFile();
                return false;
            });
        },
        _render: function () {
            var self = this, container = $(self.container), list = $(self.fileList), load = $(self.fileOperation), tagContainer = load.find(".input-group-btn"), prev = self.$element.prev(), next = self.$element.next(), parent = self.$element.parent();
            self.list = list;
            self.package = container;
            container.append(list);
            container.append(load);
            tagContainer.append(self.$element);
            load.on('click', ".btn-select", function () {
                self.$element.trigger("click");
                return false;
            });
            self.$element.on("change", function () {
                self._loadFile();
            });
            if (prev.length)
                prev.after(container);
            else if (next.length)
                next.before(container);
            else parent.append(container);
            $.each(self.files, function (index, obj) {
                self._addFile(obj);
            });
            self.noteTag = load.find("span.text-danger");
        },
        _data: function (option) {
            return this.each(function () {
                var $this = $(this)
                var data = $this.data('bs.tab')

                if (!data) $this.data('bs.tab', (data = new Tab(this)))
                if (typeof option == 'string') data[option]()
            })
        },
        container: '<div class="file_container">',
        fileList: '<div class="file_attachments">',
        file: '<div class="file_attachment">',
        fileSign: '<div class="file_sign"><div class="file_img_container"><img src="{url}" class="file_img" /></div></div>',
        fileDescription: '<div class="file_description"><span class="file_note">{name}</span></div>',
        fileSize: '<div class="file_info"><span class="file_note">{size}</span></div>',
        fileRemove: '<div class="file_remove"><span class="file_note" data-tooltip="tooltip"><i class="glyphicon glyphicon-trash" title="移除"></i></span></div>',
        fileOperation: '<div class="input-group file_operation"><div class="form-control"><span class="text-danger"></span></div><div class="input-group-btn"><button class="btn btn-primary btn-select"><i class="glyphicon glyphicon-folder-open"></i> 选择...</button><button class="btn btn-default btn-upload"><i class="glyphicon glyphicon-upload"></i> 上传</button></div></div>'
    };

    $.fn.cscecfile = function (option) {
        if (!hasFileAPISupport() && !isIE(9)) {
            return;
        }
        if (typeof option === "string") {
            return this.cscecfile.data(this, option);
        }
        var args = Array.apply(null, arguments), retvals = [];
        this.each(function () {
            var self = $(this), data = self.data('cscecfile'), options = typeof option === 'object' && option, opts;
            if (!data) {
                opts = $.extend(true, {}, $.fn.cscecfile.defaults, options, self.data());
                if (typeof opts.files == "string") opts.files = eval(opts.files);
                data = new CscecFile(this, opts);
                self.data('cscecfile', data);
            }
        });
        return this;
    };
    $.fn.cscecfile.data = function (jq, option) {
        var self = jq.data("cscecfile"), opt = option.toLowerCase(), obj;
        if (!self) throw new error("对象尚未初始化...[$().cscec()]");
        switch (opt) {
            case "data":
                obj = self;
                break;
            case "formdata":
                obj = self._analysisFormData();
                break;
            default:
        }
        return obj;
    };
    $.fn.cscecfile.defaults = {
        minFileCount: 0,
        maxFileCount: 99,
        maxFileSize: 1024 * 1024 * 10,
        extension: "",
        docImgUrl: '',
        docxImgUrl: '',
        pptImgUrl: '',
        pptxImgUrl: '',
        xlsImgUrl: '',
        xlsxImgUrl: '',
        defaultUrl: '',
        unkownFileUrl: '/img/file.png',
        files: [],
        url: null,
    };
    $.fn.cscecfile.Constructor = CscecFile;

    $(function () {
        var $input = $("input.cscecfile[type=file]");
        if ($input.length) {
            var result = $input.cscecfile();
        }
    });

}));
