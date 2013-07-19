var movePoint = 64;
Character = function(obj){
	this.id = obj.userId;
	this.chaImg = obj.userImg;
	this.gpsX = obj.gpsX;
	this.gpsY = obj.gpsY;
	this.movingDistance = obj.movingDistance;
	this.playerDiv = "<div id='player_"+this.id+"' class='player'></div>";
	$("#map").append(this.playerDiv);
	var x = parseInt(this.gpsX)*movePoint;
	var y = parseInt(this.gpsY)*movePoint;
	$("#player_"+this.id).css("left",x);
	$("#player_"+this.id).css("top",y);
	$("#player_"+this.id).css("background","url('./contents/images/character1/"+this.chaImg+"') no-repeat");
};

//캐릭터 클릭 메소드
Character.prototype.playerClick = function(){
	var movingDistance = parseInt(this.movingDistance);
	var userId = this.id;
	alert(userId+"&&&&&"+loginUser);
	if(userId===loginUser){
		$("#player_"+this.id).click(function(){
			var position = $(this).position();//현재 캐릭터의 포지션을 구함
			var x = position.left/movePoint;//무브포인트로 나누면 그것은 td의 id값!!
			var y = position.top/movePoint;
			//우측 right 범위
			var x_right = x+movingDistance;
			for(var i=x+1; i<=x_right;i++){
				$("#field_table td[id="+i+"_"+y+"]").addClass("select_td");
			}
			//좌측 left 범위
			var x_left = x-movingDistance;
			for(var i=x-1; i>=x_left;i--){
				$("#field_table td[id="+i+"_"+y+"]").addClass("select_td");
			}
	
			//하단 bottom 범위
			var y_bottom = y+movingDistance;
			for(var i=y+1; i<=y_bottom;i++){
				$("#field_table td[id="+x+"_"+i+"]").addClass("select_td");
			}
	
			//상단 top 범위
			var y_top = y-movingDistance;
			for(var i=y-1; i>=y_top;i--){
				$("#field_table td[id="+x+"_"+i+"]").addClass("select_td");
			}	
	
			//NW ,  SW
			var k = Math.abs(y_top - y)-1;
			for(var i=x-1; i>x_left; i--){
				for(var j=y-k; j<y; j++){
					$("#field_table td[id="+i+"_"+j+"]").addClass("select_td");
				}
				for(var j=y+k; j>y; j--){
					$("#field_table td[id="+i+"_"+j+"]").addClass("select_td");
				}
				k--;
			}
			//NE  ,  SE
			var k2 = Math.abs(y_top - y)-1;
			for(var i=x+1; i<x_right; i++){
				for(var j=y-k2; j<y; j++){
					$("#field_table td[id="+i+"_"+j+"]").addClass("select_td");
				}
				for(var j=y+k2; j>y; j--){
					$("#field_table td[id="+i+"_"+j+"]").addClass("select_td");
				}
				k2--;
			}	
		});
	}
};

//캐릭터 이동 메소드
Character.prototype.playerMove = function(){
	var userId = this.id;
	if(userId===loginUser){
		$("#field_table td").click(function(){
			var id=this.id;//선택학 td의 id값을 구한다.
		
			var cssClz = $("#"+id).attr("class");//클래스값을 세팅한다.
			if(cssClz!=undefined&&cssClz==='select_td'){ //이동가능 범위인 동시에 클래스가 있다면 실행
				var xy = id.split("_"); 
				var xxx = parseInt(xy[0])*movePoint;//스플릿한 id값. x값에 무빙포인트를 곱하면 x축으로 이동해야 할 거리가 나온다
				var yyy = parseInt(xy[1])*movePoint;
				var position = $("#player_"+userId).position();
				var px = position.left/movePoint;
				var py = position.top/movePoint;
				if(px!=xy[0]){//x축의 현재 캐릭터 위치와 이동해야 할 값이 다르면 실행
					$("#player_"+userId).animate({"left":xxx+"px"},500,'linear');
				}
				if(py!=xy[1]){
					$("#player_"+userId).animate({"top":yyy+"px"},500,'linear');
				}
				$("#field_table td").removeClass("select_td");
			}else{
				//아무것도 실행하지 않는다.
			}
		});
	}
};


