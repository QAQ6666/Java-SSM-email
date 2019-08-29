/*---LEFT BAR ACCORDION----*/
$(function() {
    $('#nav-accordion').dcAccordion({
        eventType: 'click',
        autoClose: true,
        saveState: true,
        disableLink: true,
        speed: 'slow',
        showCount: false,
        autoExpand: true,
// cookie: 'dcjq-accordion-1',
        classExpand: 'dcjq-current-parent'
    });
});

var Script = function () {


// sidebar dropdown menu auto scrolling

    jQuery('#sidebar .sub-menu > a').click(function () {
        var o = ($(this).offset());
        diff = 250 - o.top;
        if(diff>0)
            $("#sidebar").scrollTo("-="+Math.abs(diff),500);
        else
            $("#sidebar").scrollTo("+="+Math.abs(diff),500);
    });



// sidebar toggle

    $(function() {
        function responsiveView() {
            var wSize = $(window).width();
            if (wSize <= 768) {
                $('#container').addClass('sidebar-close');
                $('#sidebar > ul').hide();
            }

            if (wSize > 768) {
                $('#container').removeClass('sidebar-close');
                $('#sidebar > ul').show();
            }
        }
        $(window).on('load', responsiveView);
        $(window).on('resize', responsiveView);
    });

    $('.fa-bars').click(function () {
        if ($('#sidebar > ul').is(":visible") === true) {
            $('#main-content').css({
                'margin-left': '0px'
            });
            $('#sidebar').css({
                'margin-left': '-210px'
            });
            $('#sidebar > ul').hide();
            $("#container").addClass("sidebar-closed");
        } else {
            $('#main-content').css({
                'margin-left': '210px'
            });
            $('#sidebar > ul').show();
            $('#sidebar').css({
                'margin-left': '0'
            });
            $("#container").removeClass("sidebar-closed");
        }
    });

// custom scrollbar
    $("#sidebar").niceScroll({styler:"fb",cursorcolor:"#4ECDC4", cursorwidth: '3', cursorborderradius: '10px', background: '#404040', spacebarenabled:false, cursorborder: ''});

    $("html").niceScroll({styler:"fb",cursorcolor:"#4ECDC4", cursorwidth: '6', cursorborderradius: '10px', background: '#404040', spacebarenabled:false,  cursorborder: '', zindex: '1000'});

// widget tools

    jQuery('.panel .tools .fa-chevron-down').click(function () {
        var el = jQuery(this).parents(".panel").children(".panel-body");
        if (jQuery(this).hasClass("fa-chevron-down")) {
            jQuery(this).removeClass("fa-chevron-down").addClass("fa-chevron-up");
            el.slideUp(200);
        } else {
            jQuery(this).removeClass("fa-chevron-up").addClass("fa-chevron-down");
            el.slideDown(200);
        }
    });

    jQuery('.panel .tools .fa-times').click(function () {
        jQuery(this).parents(".panel").parent().remove();
    });

// tool tips

    $('.tooltips').tooltip();

// popovers

    $('.popovers').popover();



// custom bar chart

    if ($(".custom-bar-chart")) {
        $(".bar").each(function () {
            var i = $(this).find(".value").html();
            $(this).find(".value").html("");
            $(this).find(".value").animate({
                height: i
            }, 2000)
        })
    }
	
	$(".openfile").click(function(){
		let obj = $(this).siblings("input[name=annex]")
		obj.click()
	})


}();
$(function(){
	function isINPUTstr(obj,str){
		obj.siblings("p").text(str)
		obj.siblings("p").removeClass("correctINPUT")
		obj.siblings("p").addClass("errorINPUT");
	}
	$("#SendEmail").submit(function(e){
		let t = $(this).serializeArray();
		let pNameList = new Array()
        $.each(t,function(i,item){
			let pName = $("#"+$(item).attr("name"))
			pNameList.push(pName)
            if(item['value'] == '') {
				isINPUTstr(pName,"Not nullable")
                e.preventDefault();
                return false
            }
        })
		
		if(pNameList[0].val().length >100){
			isINPUTstr(pNameList[0],"Length cannot be greater than 100")
			e.preventDefault();
			return false
		}
		if(pNameList[1].val().length >50){
			isINPUTstr(pNameList[0],"Length cannot be greater than 50")
			e.preventDefault();
			return false
		}
		if(pNameList[2].val().length >3000){
			isINPUTstr(pNameList[0],"Length cannot be greater than 3000")
			e.preventDefault();
			return false
		}
		
})
	
	$("#logout").click(function(e){
		 let msg = "您确定要退出当前账号吗？";
        if (confirm(msg)==true){
        	// 发送退出请求
        	$.post("logout",function(data,status ){
				console.log("Data: " + data + "nStatus:"+status );
				if(data=="false"){
					alert("Logout failed")
				}
    });
			return true;
		}else{
			return false;
		}
	})
	/** 模态框js** */
	$("#isshow").click(function(){
		console.log("Dj2")
		$("#modal-13").addClass("md-show");
	})
	$(".md-close").click(function(){
		$("#modal-13").removeClass("md-show");
	})
	$(".md-overlay").click(function(){
		$(".md-close").click()
		$(".md-closeEight").click()
		$(".md-closeNine").click()
	})
	$("#ishowEight").click(function(){
		$("#modal-8").addClass("md-show");
	})
	$(".md-closeEight").click(function(){
		$("#modal-8").removeClass("md-show");
	})
	let draftlist = false;
	$("#showDraft").click(function(){
		$("#modal-9").addClass("md-show");
		if(!draftlist){
			$.post("ShowDraft",function(result){
				console.log( result)
				if((typeof result)=="object"){
					let add = $(".addTbody")
					$.each(result, function(i,val){
						add.append(`<tr>
						<td>${val.ddata}</td>
						<td>${val.drecipient==""?"未填写":val.drecipient}</td>
						<td>${val.dtheme==""?"未填写":val.dtheme}</td></tr>`)});
					draftlist = true
				}else{
					alert(result)
				}
			  },"JSON");
		}
	})
	$(".md-closeNine").click(function(){
		$("#modal-9").removeClass("md-show");
	})
	
	
	let isfeed = false;
	$(".sendFeed").click(function(e){
		if(isfeed){
			alert("Submitting, please wait");
		}else{
			isfeed = true;
			let eve = $(e.target);
			let val = $(".feedbackVALUE").val();
			$.post("feedback",{val:val},function(result){
				console.log(result)
				if(result=="y"){
					alert("Sent successfully,Please wait for the administrator to pass");
				}else{
					alert("Failed to send");
				}
				isfeed = false
			  });
		}
	})
	
	$("#saveEmail").click(function(e){
		
		let eve  = $(e.target)
		let endname= $("#recipient").val()
		let theme= $("#theme").val()
		let content = $("#content").val()
		
		if(theme=="" && content==""){
			alert("One of the topics and content must have content")
		}else{
			eve.attr("disable",true)
			$.post("saveUserEmail",{endname,theme,content},function(data,status ){
				eve.attr("disable",false)
				if(data="1"){
					alert("Save failed, please try again")
				}else{
					alert("Successfully saved")
				}
	});
		}
	
	})
	
})