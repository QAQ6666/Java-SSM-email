function isEmojiCharacter(substring) { // 判断输入的内容是否包含自己的表情
	for (var i = 0; i < substring.length; i++) {
		var hs = substring.charCodeAt(i);
		if (0xd800 <= hs && hs <= 0xdbff) {
			if (substring.length > 1) {
				var ls = substring.charCodeAt(i + 1);
				var uc = ((hs - 0xd800) * 0x400) + (ls - 0xdc00) + 0x10000;
				if (0x1d000 <= uc && uc <= 0x1f77f) {
					return true;
				}
			}
		} else if (substring.length > 1) {
			var ls = substring.charCodeAt(i + 1);
			if (ls == 0x20e3) {
				return true;
			}
		} else {
			if (0x2100 <= hs && hs <= 0x27ff) {
				return true;
			} else if (0x2B05 <= hs && hs <= 0x2b07) {
				return true;
			} else if (0x2934 <= hs && hs <= 0x2935) {
				return true;
			} else if (0x3297 <= hs && hs <= 0x3299) {
				return true;
			} else if (hs == 0xa9 || hs == 0xae || hs == 0x303d || hs == 0x3030 ||
				hs == 0x2b55 || hs == 0x2b1c || hs == 0x2b1b ||
				hs == 0x2b50) {
				return true;
			}
		}
	}
}

function veriNAME(val) { // 判断注册时，用户名的输入内容
	let p = /[0-9]/;
	if (p.test(val)) {
		return ("Can't contain numbers");
		return;
	}
	let reg = /[~#^$@%&!?%*]/gi;
	if (reg.test(val.trim())) {
		return ("Name cannot contain special characters");
	} else {
		if (isEmojiCharacter(val.trim())) {
			return ("Name cannot contain expressions");
		} else {
			return true // 表示验证通过
		}
	}
}

function veriPWD(val) { // 判断注册时，密码的输入内容
	if (isEmojiCharacter(val.trim())) {
		return ("Name cannot contain expressions");
	} else {
		return true // 表示验证通过
	}
}

function veriPWDagain(val, againVAL) { // 判断注册时，确认密码的输入内容
	isnull(val)
	if (againVAL !== val) {
		return ("Two passwords are inconsistent");
	} else {
		return true // 表示验证通过
	}
}

function veriEMAIL(val) { // 判断注册时，邮箱的格式正确
	var myReg = /^[a-zA-Z0-9_-]+@([a-zA-Z0-9]+\.)+(com|cn|net|org)$/;
	if (myReg.test(val)) {
		return true
	} else {
		return ("The mailbox format is incorrect");
	}
}

function veriCODE(val) { // 判断验证码的正确
	isnull(val)
	if (val.length == 5) {
		if (val.indexOf(" ") >= 0) {
			return ("Input cannot have spaces");
		} else {
			return true
		}
	} else {
		return ("The length of the verification code is 5")
	}
}
// 判断内容是否为空
function isnull(strval){
	if(strval==null || strval===""){
		return "Empty content";
	}
}

function format(val, fun) { // 基本输入判断
	isnull(val)
	if (val.length >= 6 && val.length<= 20 ) {
		if (val.indexOf(" ") >= 0) {
			return ("Input cannot have spaces");
		} else {
		 return fun(val);
		}
	} else {
		return ("Length must be greater than 6 or less than or equal to 20")
	}
}


function setSibling(obj,str){   // 设置兄弟元素的内容
	let pro = obj.siblings(".prompt")
	pro.removeClass("prompt-green")
	pro.removeClass("prompt-red")
	if(str==true){
		pro.text("Correct format");
		pro.addClass("prompt-green");
		return true;
	}
	pro.text(str)
	pro.addClass("prompt-red");
	return false
}

function setINPUTCON(setName, setFun) { // 为每个input设置监听函数
	$("#" + setName).keyup(function() {
		let str = format($(this).val(), setFun)
		return setSibling($(this),str)
	});
}

function setInOTHER(inName,fun){
	$("#"+inName).keyup(function() {  // 为每个input设置监听函数
		let pwdstr = $("#password").val()
		let str = fun(pwdstr,$(this).val())
		setSibling($(this),str)
	});
}

function istoReForm(){
	let username = $('#username');
	let email = $('#email');
	let password = $('#password');
	let code = $("#code")
	let pwdAGAIN = $("#pwdAGAIN")
		let str = format(username.val(), veriNAME)
		if(!setSibling(username,str)){
			return false
		}
		 str = format(email.val(), veriEMAIL)
		if(!setSibling(email,str)){
			return false
		}
		 str = format(password.val(), veriPWD)
		if(!setSibling(password,str)){
			return false
		}
		 str = veriCODE(code.val())
		if(!setSibling(code,str)){
			return false
		}
		
		 str = veriPWDagain(password.val(),pwdAGAIN.val())
		if(!setSibling(pwdAGAIN,str)){
			return false
		}
		return true
}

function istoLoform(){
	let objname = $('#loginname');
	let objpwd = $('#loginpassword');
	let str = format(objname.val(), veriNAME)
	 if(!setSibling(objname,str)){
	 	return false
	 }
	 str = format(objpwd.val(), veriPWD)
	if(!setSibling(objpwd,str)){
		return false
	}
	return true
}

$(function(){
	setINPUTCON("username",veriNAME)
	setINPUTCON("email",veriEMAIL)
	setINPUTCON("password",veriPWD)
	
	$("#code").keyup(function() {  
		let str = veriCODE($(this).val())
		setSibling($(this),str)
	});
	setInOTHER("pwdAGAIN",veriPWDagain)
	
	setINPUTCON("loginname",veriNAME)
	setINPUTCON("loginpassword",veriPWD)
	
	$("#loginform").submit(function(e){
		
		if(!istoLoform()){
			console.log("不可提交login")
			e.preventDefault();
		}
	})
	
	$("#registerform").submit(function(e){
		if(!istoReForm()){
			console.log("不可提交reg")
			e.preventDefault();
		}
	})
	$("#getLOGCODE").click(function(e){
		let str = $("#email").val()
		let istrue = veriEMAIL(str)
		let is =  setSibling($("#email"),istrue)
		
		console.log(is)
		
		if(is){
			let event = e.target
			let time = 59
			event.value = time
			$(event).attr("disabled",true);
			// 发送请求去后端
			$.post("Sendcode",{email:str},function(data,status ){
				console.log("Data: " + data + "nStatus:"+status );
    });
			
			let clock = window.setInterval(function(){
				console.log("开始了")
				event.value = time
				time--
	 			if(time<=0){
	 				return false;
	 			}
			},1000)
	 		
	 		setTimeout(function(){
	 			window.clearInterval(clock)
	 			event.value = ("Get Code")
	 			$(event).attr("disabled",false);
	 		},60000) 
		}else{
			alert("Please enter or correctly enter your email address first.")
			
		}
	})
	
})
