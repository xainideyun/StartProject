/**
 * 
 * @authors Your Name (you@example.org)
 * @date    2016-12-15 16:13:00
 * @version $Id$
 */

(function($){
	
	var $btn = $("#btn"), $content = $(".content"), num = 0, 
		msgInfo = ["好想化做一只蝴蝶 乘着微风振翅高飞", "现在马上 只想赶快和你见面", "烦心的事放在一边 如果忘记那也无所谓", "已经没有 多余时间可以浪费", "似乎有 WOW WOW~ 什么事会在这片晴空下出现", "就算是 WOW WOW~ 面对未知的明天勇敢去冒险"];
	
	registerClick();

	function registerClick(){
		$btn.one("click", function(){
			if(num === msgInfo.length)num = 0;
			$content.empty().append($("<p>").addClass("msg-animation").addClass("msg").text(msgInfo[num++]));
			next(registerClick, 3000);
		});
	}

	$btn.click();

	function next(callback, delayedTime){
		setTimeout(callback, delayedTime);
	}

})(jQuery);
