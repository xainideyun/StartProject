/**
 * 
 * @authors Dancy Sun (sunxsaljj@163.com)
 * @date    2016-10-17 08:51:20
 * @version 1.0.0
 */
(function (factory) {
    "use strict";
    if (typeof define === 'function' && define.amd) {
        define(['jquery'], factory);
    } else {
        if (typeof module === 'object' && module.exports) {
            module.exports = factory(require('jquery'));
        } else {
            factory(window.jQuery);
        }
    }
})(function ($) {
    "use strict";

    var NAMESPACE, CscecTable, getNum;

    NAMESPACE = '.cscectable';
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
    CscecTable = function(element, options){
        var self = this;
        self.$element = $(element);
        if(!self._validate()){
            return;
        }
        self._init(options);
        self._Listen();
    };
    CscecTable.prototype = {
        constructor: CscecTable,
        _init: function(options){
            var self = this, $el = self.$element;
            $.each(options, function (key, value) {
                switch (key) {
                    case 'pageSize':
                    case 'pageIndex':
                        self[key] = getNum(value);
                        break;
                    default:
                        self[key] = value;
                        break;
                }
            });
            self.options = options;
            self.$container = self._createContainer();
            self.$recordNote = self._createRecordNote();
            self.$pagination = self._createPagination();
            self._load();
            console.log(self);
        },
        _Listen: function(){
            var self = this, row, field, $tr, $td, prev, next, $li;
            self.$body
            .on("click", "tr", function(e){
                if(self.handler.onRowClick){
                    e.stopPropagation();
                    $tr = $(this);
                    $td = $(e.target);
                    row = $tr.data("rowData");
                    prev = $td.prevAll().length;
                    if(!self.isSequence){
                        field = self.$colunmsMap[prev].field;
                    }
                    else{
                        field = prev === 0 ? undefined : self.$colunmsMap[prev - 1].field
                    }
                    self.handler.onRowClick(row, $tr, $td, field);
                }
            });
            self.$pagination.on("click", "li:not(.active,.disabled)", function(e){
                $li = $(this);
                prev = $li.prevAll().length;
                next = $li.nextAll().length;
                if(prev === 0 && self.pageIndex > 1){
                    self.pageIndex--;
                }
                else if(next === 0 && self.pageIndex < self.pageCount){
                    self.pageIndex++;
                }
                else{
                    self.pageIndex = getNum($li.text());
                }
                self._refreshData();
            });
        },
        _validate: function(){
            var self = this, $exception;
            if (self.$element.get(0).tagName === 'TABLE') {
                return true;
            }
            $exception = '<div class="help-block alert alert-warning">' +
                '<h4>无效的标记类型</h4>' +
                '您必须使用标记 <code>table</code> 作为 <b>cscectable</b> 插件的初始化控件' +
                '</div>';
            self.$element.after($exception);
            return false;
        },
        _validateJOSN: function(data){
            var self = this;
            if(!data.total || !data.rows){
                self._dataFormatIncorrect();
                throw new Error('返回的数据格式不正确，如{total:20,rows:[]}');
            }
            return true;
        },
        _createContainer: function () {
            var self = this, $container = $(document.createElement("div"))
                .attr({"class": 'panel panel-default table-responsive cscec-table'});
            self.$element.wrap($container);
            $container = self.$element.parent();
            return $container;
        },
        _createRecordNote: function(){
            var self = this, $recordNoteContainer = $("<div>")
                .attr({"class": "pull-left pagination-detail"}), $recordNoteLabel = $("<label>共<span class='pagination-note'></span>条记录</label>")
                .appendTo($recordNoteContainer), $recordNote = $recordNoteLabel.find("span");
            self.$container.append($recordNoteContainer);
            return $recordNote;
        },
        _createPagination: function(){
            var self = this, $paginationContainer = $("<div>")
                .attr({"class": "pull-right"}), $pagination = $("<ul>")
                .attr({"class": "pagination"})
                .appendTo($paginationContainer);
            self.$container.append($paginationContainer);
            return $pagination;
        },
        _createPaginationLi: function(sign){
            var self = this, $li = $("<li>")
                .append($("<a href='javascript:void(0)'></a>").html(sign));
            if(sign === self.pageIndex)
                $li.attr('class', 'active');
            if(typeof sign !== "number")$li.addClass("disabled");
            self.$pagination.append($li);
            return $li;
        },
        _setTotalRecord: function(){
            var self = this;
            self.$recordNote.html(self.total);
        },
        _setPagination: function(){
            var self = this, pageCount = Math.ceil(self.total / self.pageSize), $prev = $("<li>")
                .append($("<a href='javascript:void(0)'>&laquo;</a>")), $next = $("<li>")
                .append($("<a href='javascript:void(0)'>&raquo;</a>")), $li;
            if(self.total === 0)return;
            self.pageCount = pageCount;
            self.$pagination.empty();
            self.$pagination.append($prev);
            if(self.pageIndex === 1)
                $prev.attr('class', 'disabled');

            if(pageCount <= 7){
                for (var i = 1; i <= pageCount; i++) {
                    self._createPaginationLi(i);
                }
            }
            else{
                if(self.pageIndex < 5){
                    for (var i = 1; i < 5; i++) {
                        self._createPaginationLi(i);
                    }
                    self._createPaginationLi("...");
                    self._createPaginationLi(pageCount);
                }
                else if(self.pageIndex + 4 > pageCount){
                    self._createPaginationLi(1);
                    self._createPaginationLi("...");
                    for (var i = 3; i >= 0; i--) {
                        self._createPaginationLi(pageCount - i);
                    }
                }
                else{
                    self._createPaginationLi(1);
                    self._createPaginationLi("...");
                    self._createPaginationLi(self.pageIndex - 1);
                    self._createPaginationLi(self.pageIndex);
                    self._createPaginationLi(self.pageIndex + 1);
                    self._createPaginationLi("...");
                    self._createPaginationLi(pageCount);
                }
            }

            self.$pagination.append($next);
            if(self.pageIndex === pageCount)
                $next.attr('class', 'disabled');
        },
        _load: function(){
            var self = this, $el = self.$element;
            $el.empty();
            self._setTableHeader();
            self._refreshData();
        },
        _setTableHeader: function(){
            var self = this, $el = self.$element, $head = $(document.createElement("thead"))
                .appendTo($el), $headTr = $(document.createElement("tr")).appendTo($head), $columnsCount = 0, $colunmsMap = [];
            self.$head = $head;
            if(!self.columns.length){
                self._columnsErrors();
            }
            if(self.isSequence){
                $headTr.append($("<td>").text('序号'));
                $columnsCount++;
            }
            $.each(self.columns,function(index, obj){
                self._addHeader(obj);
                $colunmsMap.push({'index': index, 'field': obj.field})
                $columnsCount++;
            });
            self.$columnsCount = $columnsCount;
            self.$colunmsMap = $colunmsMap;
        },
        _addHeader: function(obj){
            var self = this, $headTr = self.$head.find("tr");
            $headTr.append($("<td>").text(obj.name));
        },
        _refreshData: function(){
            var self = this, $el = self.$element, $body = self.$body || $(document.createElement("tbody"));
            if(!self.$body){
                self.$body = $body;
                $el.append($body);
            }
            $body.empty();
            self._ajaxSubmit();
        },
        _loadingData: function(){
            var self = this, $sequence = (self.pageIndex - 1) * self.pageSize + 1,
                $tr = $("<tr>"), $tds;
            for(var i = 0; i < self.$columnsCount; i++){
                $tr.append($("<td>"));
            }
            if(!self.rows.length){
                self._rowEmpty();
            }
            $.each(self.rows, function(index, row){
                $tds = $tr.clone().data("rowData", row).appendTo(self.$body).find("td");
                if(self.isSequence){
                    $(Array.prototype.shift.call($tds)).text($sequence++);
                }
                $.each(self.$colunmsMap, function(index, obj){
                    $($tds[index]).text(row[obj.field]);
                });
            });
            self._setPagination();
            self._setTotalRecord();
        },
        _ajaxSubmit: function(){
            var self = this, settings, queryParams = {
                'sort': self.sort, 'sortExpression': self.sortDescription, 'pageIndex': self.pageIndex, 
                'pageSize': self.pageSize
            };
            settings = {
                self: self,
                url: self.url,
                type: 'POST',
                dataType: 'json',
                data: queryParams,
                cache: false,
                beforeSend: self._fnBefore,
                success: self._fnSuccess,
                complete: self._fnComplete,
                error: self._fnError
            };
            $.ajax(settings);
        },
        _fnBefore: function(){
            
        },
        _fnSuccess: function(data, status, xhr){
            var self = this.self;
            self._validateJOSN(data);
            $.extend(self, data);
            self._loadingData();
        },
        _fnComplete: function(){
            
        },
        _fnError: function(){
            
        },
        _columnsErrors: function(){
            throw new Error("the columns is null...");
        },
        _rowEmpty: function(){
            var self = this;
            self.$body.append($("<tr>").append($("<td>").attr("colspan", self.$columnsCount).text(self.emptyDataNote)));
        },
        _dataFormatIncorrect: function(){
            var self = this;
            self.$body.append($("<tr>").append($("<td>").attr("colspan", self.$columnsCount).addClass("text-error").text(self.dataFormatIncorrect)));
        }
    };


    $.fn.cscectable = function(option){
        var args = Array.apply(null, arguments), retvals = [];
        args.shift();
        this.each(function(){
            var self = $(this), data = self.data('cscectable'), options = typeof option === 'object' && option, opts;
            if(!data){
                opts = $.extend(true, {}, $.fn.cscectable.defaults, options, self.data());
                data = new CscecTable(this, opts);
                self.data('cscectable', data);
            }

            if(typeof option === 'string'){
                retvals.push(data[option].apply(data, args));
            }
        });
        switch(retvals.length){
            case 0:
                return this;
            case 1:
                return retvals[0];
            case 2:
                return retvals;
        }
    };
    $.fn.cscectable.defaults = {
        pageSize: 15,
        pageIndex: 1,
        pagination: false,
        sort: 'asc',
        sortDescription: 'id',
        url: null,
        total: 0,
        rows: [],
        columns:[],
        isSequence: true,
        emptyDataNote: '查询无数据...',
        dataFormatIncorrect: '返回的数据格式不正确...'
    };
});