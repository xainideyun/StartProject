/**
 * 
 * @authors dancy sun (sunxsaljj@163.com)
 * @date    2016-12-14 22:59:41
 * @version $Id$
 */

(function($){
	var pageInfo = {
		title_en: "Marry Christmas",
		title_ch: "圣诞快乐",
		name: "小灰灰",
		music: ["小跳蛙", "棉花糖", "我不愿让你一个人", "我想大声告诉你", "愿得一人心", "如果我变成回忆", "你那么爱他", "豆浆油条"],
		msg: ["只愿得一人心", "白首不分离", "这清晰的话语需要巨大的勇气"],
		expend: false
	};

	var pageCtrl = {
		body: $("body"),
		title: $("title"),
		en: $("#title-en"),
		ch: $("#title-ch"),
		name: $("#name"),
		container: $(".list-container"),
		list: $(".music-list"),
		btn: $(".faward"),
		next: $("#next")
	};
	pageCtrl.title.text(pageInfo.title_ch + "-" + pageInfo.name);
	pageCtrl.en.text(pageInfo.title_en);
	pageCtrl.ch.text(pageInfo.title_ch);
	pageCtrl.name.text(pageInfo.name);

	$.each(pageInfo.music, function(index, item){
		pageCtrl.list.append($("<li>").append($("<a href=\"#\">").text(item)));
	});

	pageCtrl.list.on("click", "li>a",function(){
		var self = $(this);
		var name = self.text();
		musicPlay("data/" + name + ".mp3");
		pageCtrl.list.find("li").removeClass("active");
		self.closest("li").addClass('active');
	});
	pageCtrl.btn.on("click", function(){
		pageCtrl.btn.empty();
		pageInfo.expend = !pageInfo.expend;
		if(pageInfo.expend){
			pageCtrl.btn.append($("<i class='glyphicon glyphicon-backward'>"));
			pageCtrl.container.css("left", "0");
		}
		else{
			pageCtrl.btn.append($("<i class='glyphicon glyphicon-forward'>"));
			pageCtrl.container.css("left", "-" + pageInfo.listWidth + "px");
		}
	});

	pageCtrl.btn.css({height: pageCtrl.container.height(), lineHeight: pageCtrl.container.height() + "px"});
	pageInfo.listWidth = pageCtrl.list.width();
	pageCtrl.container.css("left", "-" + pageInfo.listWidth + "px");

	var media = document.getElementById("musicBox");
	if(wx){
		wx.config({

		});
		wx.ready(function () {
			musicPlay("data/" + pageInfo.music[0] + ".mp3");
			$(pageCtrl.list.find("li")[0]).addClass('active');
		});
	}

	function musicPlay(url){
		wx.ready(function () {
		    media.src = url;
		    media.play();
		});
	}

	var msgNum = 0;
	pageCtrl.next.on("click", function(){
		if(msgNum === pageInfo.msg.length)return;
		$(".narrator").remove();
		$("<p class=\"narrator\">").text(pageInfo.msg[msgNum++]).appendTo(pageCtrl.body);
	}).trigger('click');

})(jQuery);
