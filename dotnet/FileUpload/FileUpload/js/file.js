var file = $(".file").fileinput();

file.fileinput({
    language: 'zh',
    uploadUrl: '/File/Upload',
    allowedFileExtensions: ['jpg', 'png', 'gif', 'doc'],
})
