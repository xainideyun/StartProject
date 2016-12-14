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
		music: ["棉花糖", "我不愿让你一个人", "我想大声告诉你", "愿得一人心", "如果我变成回忆", "你那么爱他", "豆浆油条"]
	};

	var pageCtrl = {
		en: $("#title-en"),
		ch: $("#title-ch"),
		name: $("#name"),
		music: $("#music"),
		musicMsg: $("#music-msg")
	};
	pageCtrl.en.text(pageInfo.title_en);
	pageCtrl.ch.text(pageInfo.title_ch);
	pageCtrl.name.text(pageInfo.name);
	$.each(pageInfo.music, function(index, item){
		pageCtrl.music.append($("<option>").attr("value", "data/" + item + ".mp3").text(item));
	});
	pageCtrl.musicMsg.text(pageInfo.music[0])
		.on("click", function(){
			pageCtrl.music.click()
		});
	pageCtrl.music.on("change", function(){
		var musicName = $(this).val();
		if(wx){
			musicPlay(musicName);
		}
		pageCtrl.musicMsg.text($(this).find(":selected").text());
	});

	var media = document.getElementById("musicBox");
	if(wx){
		wx.config({

		});
		wx.ready(function () {
			musicPlay(pageCtrl.music.val());
		});
	}

	function musicPlay(url){
		wx.ready(function () {
		    media.src = url;
		    media.play();
		});
	}

})(jQuery);
