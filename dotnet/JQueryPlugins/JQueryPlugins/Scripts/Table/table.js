
$(function () {
    $("table").cscectable({
    	url: "/Table/Get",
    	columns:[
    		{name:'姓名',field:'Name'},
    		{name:'年龄',field:'Age'},
    		{name:'用户名',field:'UserName'}
    	],
    	pageSize: 3,
    	handler: {
    		onRowClick: function(a,b,c,d){
    			console.log(a);
    			console.log(b);
    			console.log(c);
    			console.log(d);
    		}
    	}
    });
});