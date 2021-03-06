/**
 * 
 * @authors dancy sun (sunxsaljj@163.com)
 * @date    2016-12-14 22:59:41
 * @version $Id$
 */

(function($){
	var pageInfo = $.extend({}, {
		title_en: "Marry Christmas",
		title_ch: "圣诞快乐",
		name: "小灰灰",
		music: ["愿得一人心", "小跳蛙", "棉花糖", "我不愿让你一个人", "我想大声告诉你", "如果我变成回忆", "你那么爱他", "豆浆油条"],
		msg: ["只愿得一人心", "白首不分离", "这清晰的话语需要巨大的勇气"],
		expend: false
	}, personInfo);

	var pageCtrl = {
		body: $("body"),
		title: $("title"),
		en: $("#title-en"),
		ch: $("#title-ch"),
		name: $("#name"),
		container: $(".list-container"),
		list: $(".music-list"),
		btn: $(".faward"),
		next: $("#next"),
		readAll: $(".read-all"),
		read: $("#read")
	};
	pageCtrl.title.text(pageInfo.title_ch + "-" + pageInfo.name);
	pageCtrl.en.text(pageInfo.title_en);
	pageCtrl.ch.text(pageInfo.title_ch);
	pageCtrl.name.text(pageInfo.name);

	$.each(pageInfo.music, function(index, item){
		pageCtrl.list.append($("<li>").append($("<a href=\"#\">").text(item)));
	});

	pageCtrl.list.on("click", "li>a",function(){
		nextSong.call(this);
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
			wx.onMenuShareTimeline({
			    title: pageInfo.title,
			    link: pageInfo.link,
			    imgUrl: pageInfo.imgUrl,
			    desc: pageInfo.desc,
			    success: function () {
			        alert("你好吗");
			    },
			    cancel: function () { 
			        
			    }
			});
			wx.onMenuShareAppMessage({
			    title: pageInfo.title,
			    link: pageInfo.link,
			    imgUrl: pageInfo.imgUrl,
			    desc: pageInfo.desc,
			    type: '', // 分享类型,music、video或link，不填默认为link
			    dataUrl: '', // 如果type是music或video，则要提供数据链接，默认为空
			    success: function () { 
			        // 用户确认分享后执行的回调函数
			        alert("你好吗");
			    },
			    cancel: function () { 
			        // 用户取消分享后执行的回调函数
			    }
			});
		});
	}

	var msgNum = 0;
	pageCtrl.next.on("click", function(){
		if(msgNum === pageInfo.msg.length - 1){
			pageCtrl.next.text("END...");
			pageCtrl.next.off("click");
		}
		$(".narrator").remove();
		$("<p class=\"narrator\">").text(pageInfo.msg[msgNum++]).appendTo(pageCtrl.body);
	}).trigger('click');
	pageCtrl.read.on("click", function(){
		$(".narrator").remove();
		var all = $("<p class=\"narrator\">");
		pageCtrl.next.hide();
		$.each(pageInfo.msg, function(index, obj){
			all.append($("<span>").text(obj));
			all.append($("<br>"));
		});
		all.css({color: "yellow", fontSize: "15px"});
		$("body").append(all);
		pageCtrl.read.off("click").hide();
	});
	showRead(30000);

	function musicPlay(url){
	    media.src = url;
	    media.play();
	}

	function showRead(time){
		setTimeout(function(){
			pageCtrl.readAll.show();
		}, time);
	}

	function nextSong(){
		var self = $(this);
		var name = self.text();
		musicPlay("data/" + name + ".mp3");
		pageCtrl.list.find("li").removeClass("active");
		self.closest("li").addClass('active');
	}


})(jQuery);
