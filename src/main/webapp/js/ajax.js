//date validation
$(document).on('click', '#submit',function(){
	var value = $("#date").val();
	var date = new Date(value);
	var dayOfWeek = date.getDay();
	if(dayOfWeek == 0 | dayOfWeek == 6) {
		if(confirm("Are you sure? Generally, the day is holiday.")){
			//OK, nothing to do
		}else{
			//NG, cancel to submit
			return false;
		}
	}
});


//student1
$(function() {
	var requestObj = {//create object
		message : null,
		date : null,
		main : null,
		main_user : null,
		classTime : 1,
	};
	$("#user_1").change(function() {
		//リクエスト用のオブジェクトに値を詰め込む
		requestObj.message = $("#user_1 option:selected").val();
		var value = $("#date").val();
		requestObj.date = new Date(value);
		requestObj.main = $("#main").val();
		requestObj.main_user = $("#main_user").val();
		//JavaScriptのオブジェクトをJSONに変換する
		var requestJson = $.toJSON(requestObj);
		if(!requestObj.message == ""){
			$.ajax({
				type: "GET",
				url : "/helloworld/schedule/ajax",
				data: {requestJs : requestJson},
				success : function(data) {
					//alert(data.responseMessage);
					$("#book_1").empty();
					$("#book_1").append("<option value=''>--Choose Book--</option>");
					for(var i = 0; i < data.bookName.length; i++) {
						$("#book_1").append("<option value='" + data.bookName[i] + "'>" + data.bookName[i] + "</option>");
					}//"${user.name}"

					var result = data.errors.every( function( value ) {
						return value === "";
					});

					if(!result){
						alert(data.errors[0] + '\n' + data.errors[1] + '\n' + data.errors[2] + '\n' + data.errors[3]);
					} ;
				},
				error : function(XMLHttpRequest, textStatus, errorThrown) {
					alert("リクエスト時になんらかのエラーが発生しました：" + textStatus +":\n" + errorThrown);
				}

			});
		} else {
			$("#book_1").empty();
			$("#book_1").append("<option value=''>--Choose Book--</option>");
		}


	});
});

//student2
$(function() {
	var requestObj = {//create object
		message : null,
		date : null,
		main : null,
		main_user : null,
		classTime : 2,
	};
	$("#user_2").change(function() {
		//リクエスト用のオブジェクトに値を詰め込む
		requestObj.message = $("#user_2 option:selected").val();
		var value = $("#date").val();
		requestObj.date = new Date(value);
		requestObj.main = $("#main").val();
		requestObj.main_user = $("#main_user").val();
		//JavaScriptのオブジェクトをJSONに変換する
		var requestJson = $.toJSON(requestObj);
		if(!requestObj.message == ""){
			$.ajax({
				type: "GET",
				url : "/helloworld/schedule/ajax",
				data: {requestJs : requestJson},
				success : function(data) {
					//alert(data.responseMessage);
					$("#book_2").empty();
					$("#book_2").append("<option value=''>--Choose Book--</option>");
					for(var i = 0; i < data.bookName.length; i++) {
						$("#book_2").append("<option value='" + data.bookName[i] + "'>" + data.bookName[i] + "</option>");
					}//"${user.name}"

					var result = data.errors.every( function( value ) {
						return value === "";
					});

					if(!result){
						alert(data.errors[0] + '\n' + data.errors[1] + '\n' + data.errors[2] + '\n' + data.errors[3]);
					} ;
				},
				error : function(XMLHttpRequest, textStatus, errorThrown) {
					alert("リクエスト時になんらかのエラーが発生しました：" + textStatus +":\n" + errorThrown);
				}

			});
		} else {
			$("#book_2").empty();
			$("#book_2").append("<option value=''>--Choose Book--</option>");
		}


	});
});

//student3
$(function() {
	var requestObj = {//create object
		message : null,
		date : null,
		main : null,
		main_user : null,
		classTime : 3,
	};
	$("#user_3").change(function() {
		//リクエスト用のオブジェクトに値を詰め込む
		requestObj.message = $("#user_3 option:selected").val();
		var value = $("#date").val();
		requestObj.date = new Date(value);
		requestObj.main = $("#main").val();
		requestObj.main_user = $("#main_user").val();
		//JavaScriptのオブジェクトをJSONに変換する
		var requestJson = $.toJSON(requestObj);
		if(!requestObj.message == ""){
			$.ajax({
				type: "GET",
				url : "/helloworld/schedule/ajax",
				data: {requestJs : requestJson},
				success : function(data) {
					//alert(data.responseMessage);
					$("#book_3").empty();
					$("#book_3").append("<option value=''>--Choose Book--</option>");
					for(var i = 0; i < data.bookName.length; i++) {
						$("#book_3").append("<option value='" + data.bookName[i] + "'>" + data.bookName[i] + "</option>");
					}//"${user.name}"

					var result = data.errors.every( function( value ) {
						return value === "";
					});

					if(!result){
						alert(data.errors[0] + '\n' + data.errors[1] + '\n' + data.errors[2] + '\n' + data.errors[3]);
					} ;
				},
				error : function(XMLHttpRequest, textStatus, errorThrown) {
					alert("リクエスト時になんらかのエラーが発生しました：" + textStatus +":\n" + errorThrown);
				}

			});
		} else {
			$("#book_3").empty();
			$("#book_3").append("<option value=''>--Choose Book--</option>");
		}


	});
});

//student4
$(function() {
	var requestObj = {//create object
		message : null,
		date : null,
		main : null,
		main_user : null,
		classTime : 4,
	};
	$("#user_4").change(function() {
		//リクエスト用のオブジェクトに値を詰め込む
		requestObj.message = $("#user_4 option:selected").val();
		var value = $("#date").val();
		requestObj.date = new Date(value);
		requestObj.main = $("#main").val();
		requestObj.main_user = $("#main_user").val();
		//JavaScriptのオブジェクトをJSONに変換する
		var requestJson = $.toJSON(requestObj);
		if(!requestObj.message == ""){
			$.ajax({
				type: "GET",
				url : "/helloworld/schedule/ajax",
				data: {requestJs : requestJson},
				success : function(data) {
					//alert(data.responseMessage);
					$("#book_4").empty();
					$("#book_4").append("<option value=''>--Choose Book--</option>");
					for(var i = 0; i < data.bookName.length; i++) {
						$("#book_4").append("<option value='" + data.bookName[i] + "'>" + data.bookName[i] + "</option>");
					}//"${user.name}"

					var result = data.errors.every( function( value ) {
						return value === "";
					});

					if(!result){
						alert(data.errors[0] + '\n' + data.errors[1] + '\n' + data.errors[2] + '\n' + data.errors[3]);
					} ;
				},
				error : function(XMLHttpRequest, textStatus, errorThrown) {
					alert("リクエスト時になんらかのエラーが発生しました：" + textStatus +":\n" + errorThrown);
				}

			});
		} else {
			$("#book_4").empty();
			$("#book_4").append("<option value=''>--Choose Book--</option>");
		}


	});
});

//student5
$(function() {
	var requestObj = {//create object
		message : null,
		date : null,
		main : null,
		main_user : null,
		classTime : 5,
	};
	$("#user_5").change(function() {
		//リクエスト用のオブジェクトに値を詰め込む
		requestObj.message = $("#user_5 option:selected").val();
		var value = $("#date").val();
		requestObj.date = new Date(value);
		requestObj.main = $("#main").val();
		requestObj.main_user = $("#main_user").val();
		//JavaScriptのオブジェクトをJSONに変換する
		var requestJson = $.toJSON(requestObj);
		if(!requestObj.message == ""){
			$.ajax({
				type: "GET",
				url : "/helloworld/schedule/ajax",
				data: {requestJs : requestJson},
				success : function(data) {
					//alert(data.responseMessage);
					$("#book_5").empty();
					$("#book_5").append("<option value=''>--Choose Book--</option>");
					for(var i = 0; i < data.bookName.length; i++) {
						$("#book_5").append("<option value='" + data.bookName[i] + "'>" + data.bookName[i] + "</option>");
					}//"${user.name}"

					var result = data.errors.every( function( value ) {
						return value === "";
					});

					if(!result){
						alert(data.errors[0] + '\n' + data.errors[1] + '\n' + data.errors[2] + '\n' + data.errors[3]);
					} ;
				},
				error : function(XMLHttpRequest, textStatus, errorThrown) {
					alert("リクエスト時になんらかのエラーが発生しました：" + textStatus +":\n" + errorThrown);
				}

			});
		} else {
			$("#book_5").empty();
			$("#book_5").append("<option value=''>--Choose Book--</option>");
		}


	});
});

//student6
$(function() {
	var requestObj = {//create object
		message : null,
		date : null,
		main : null,
		main_user : null,
		classTime : 6,
	};
	$("#user_6").change(function() {
		//リクエスト用のオブジェクトに値を詰め込む
		requestObj.message = $("#user_6 option:selected").val();
		var value = $("#date").val();
		requestObj.date = new Date(value);
		requestObj.main = $("#main").val();
		requestObj.main_user = $("#main_user").val();
		//JavaScriptのオブジェクトをJSONに変換する
		var requestJson = $.toJSON(requestObj);
		if(!requestObj.message == ""){
			$.ajax({
				type: "GET",
				url : "/helloworld/schedule/ajax",
				data: {requestJs : requestJson},
				success : function(data) {
					//alert(data.responseMessage);
					$("#book_6").empty();
					$("#book_6").append("<option value=''>--Choose Book--</option>");
					for(var i = 0; i < data.bookName.length; i++) {
						$("#book_6").append("<option value='" + data.bookName[i] + "'>" + data.bookName[i] + "</option>");
					}//"${user.name}"

					var result = data.errors.every( function( value ) {
						return value === "";
					});

					if(!result){
						alert(data.errors[0] + '\n' + data.errors[1] + '\n' + data.errors[2] + '\n' + data.errors[3]);
					} ;
				},
				error : function(XMLHttpRequest, textStatus, errorThrown) {
					alert("リクエスト時になんらかのエラーが発生しました：" + textStatus +":\n" + errorThrown);
				}

			});
		} else {
			$("#book_6").empty();
			$("#book_6").append("<option value=''>--Choose Book--</option>");
		}


	});
});

//student7
$(function() {
	var requestObj = {//create object
		message : null,
		date : null,
		main : null,
		main_user : null,
		classTime : 7,
	};
	$("#user_7").change(function() {
		//リクエスト用のオブジェクトに値を詰め込む
		requestObj.message = $("#user_7 option:selected").val();
		var value = $("#date").val();
		requestObj.date = new Date(value);
		requestObj.main = $("#main").val();
		requestObj.main_user = $("#main_user").val();
		//JavaScriptのオブジェクトをJSONに変換する
		var requestJson = $.toJSON(requestObj);
		if(!requestObj.message == ""){
			$.ajax({
				type: "GET",
				url : "/helloworld/schedule/ajax",
				data: {requestJs : requestJson},
				success : function(data) {
					//alert(data.responseMessage);
					$("#book_7").empty();
					$("#book_7").append("<option value=''>--Choose Book--</option>");
					for(var i = 0; i < data.bookName.length; i++) {
						$("#book_7").append("<option value='" + data.bookName[i] + "'>" + data.bookName[i] + "</option>");
					}//"${user.name}"

					var result = data.errors.every( function( value ) {
						return value === "";
					});

					if(!result){
						alert(data.errors[0] + '\n' + data.errors[1] + '\n' + data.errors[2] + '\n' + data.errors[3]);
					} ;
				},
				error : function(XMLHttpRequest, textStatus, errorThrown) {
					alert("リクエスト時になんらかのエラーが発生しました：" + textStatus +":\n" + errorThrown);
				}

			});
		} else {
			$("#book_7").empty();
			$("#book_7").append("<option value=''>--Choose Book--</option>");
		}


	});
});

//student8
$(function() {
	var requestObj = {//create object
		message : null,
		date : null,
		main : null,
		main_user : null,
		classTime : 8,
	};
	$("#user_8").change(function() {
		//リクエスト用のオブジェクトに値を詰め込む
		requestObj.message = $("#user_8 option:selected").val();
		var value = $("#date").val();
		requestObj.date = new Date(value);
		requestObj.main = $("#main").val();
		requestObj.main_user = $("#main_user").val();
		//JavaScriptのオブジェクトをJSONに変換する
		var requestJson = $.toJSON(requestObj);
		if(!requestObj.message == ""){
			$.ajax({
				type: "GET",
				url : "/helloworld/schedule/ajax",
				data: {requestJs : requestJson},
				success : function(data) {
					//alert(data.responseMessage);
					$("#book_8").empty();
					$("#book_8").append("<option value=''>--Choose Book--</option>");
					for(var i = 0; i < data.bookName.length; i++) {
						$("#book_8").append("<option value='" + data.bookName[i] + "'>" + data.bookName[i] + "</option>");
					}//"${user.name}"

					var result = data.errors.every( function( value ) {
						return value === "";
					});

					if(!result){
						alert(data.errors[0] + '\n' + data.errors[1] + '\n' + data.errors[2] + '\n' + data.errors[3]);
					} ;
				},
				error : function(XMLHttpRequest, textStatus, errorThrown) {
					alert("リクエスト時になんらかのエラーが発生しました：" + textStatus +":\n" + errorThrown);
				}

			});
		} else {
			$("#book_8").empty();
			$("#book_8").append("<option value=''>--Choose Book--</option>");
		}


	});
});

//main user
$(function() {
	var requestObj = {
		message : null,
		main : null,
	};
	$("#main_student").change(function() {
		requestObj.message = $("#main_student option:selected").val();
		requestObj.main = $("#main").val();
		var requestJson = $.toJSON(requestObj);
		$.ajax({
			type: "GET",
			url : "/helloworld/schedule/ajax",
			data: {requestJs : requestJson},
			success : function(data) {
				//alert(data.responseMessage);
				$("#book_1").empty();
				$("#book_1").append("<option value=''>--Choose Book--</option>");
				for(var i = 0; i < data.bookName.length; i++) {
					$("#book_1").append("<option value='" + data.bookName[i] + "'>" + data.bookName[i] + "</option>");
				}
				$("#book_2").empty();
				$("#book_2").append("<option value=''>--Choose Book--</option>");
				for(var i = 0; i < data.bookName.length; i++) {
					$("#book_2").append("<option value='" + data.bookName[i] + "'>" + data.bookName[i] + "</option>");
				}
				$("#book_3").empty();
				$("#book_3").append("<option value=''>--Choose Book--</option>");
				for(var i = 0; i < data.bookName.length; i++) {
					$("#book_3").append("<option value='" + data.bookName[i] + "'>" + data.bookName[i] + "</option>");
				}
				$("#book_4").empty();
				$("#book_4").append("<option value=''>--Choose Book--</option>");
				for(var i = 0; i < data.bookName.length; i++) {
					$("#book_4").append("<option value='" + data.bookName[i] + "'>" + data.bookName[i] + "</option>");
				}
				$("#book_5").empty();
				$("#book_5").append("<option value=''>--Choose Book--</option>");
				for(var i = 0; i < data.bookName.length; i++) {
					$("#book_5").append("<option value='" + data.bookName[i] + "'>" + data.bookName[i] + "</option>");
				}
				$("#book_6").empty();
				$("#book_6").append("<option value=''>--Choose Book--</option>");
				for(var i = 0; i < data.bookName.length; i++) {
					$("#book_6").append("<option value='" + data.bookName[i] + "'>" + data.bookName[i] + "</option>");
				}
				$("#book_7").empty();
				$("#book_7").append("<option value=''>--Choose Book--</option>");
				for(var i = 0; i < data.bookName.length; i++) {
					$("#book_7").append("<option value='" + data.bookName[i] + "'>" + data.bookName[i] + "</option>");
				}
				$("#book_8").empty();
				$("#book_8").append("<option value=''>--Choose Book--</option>");
				for(var i = 0; i < data.bookName.length; i++) {
					$("#book_8").append("<option value='" + data.bookName[i] + "'>" + data.bookName[i] + "</option>");
				}
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				alert("リクエスト時になんらかのエラーが発生しました：" + textStatus +":\n" + errorThrown);
			}
		});

	});
});
