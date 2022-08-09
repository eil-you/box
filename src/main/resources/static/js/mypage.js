

function viewGoodsContent(g_seq, apt_name) {
	console.log(g_seq)
	console.log(apt_name)

	var f = document.createElement("form");
	var obj1 = document.createElement('input');
	obj1.setAttribute('type', 'hidden')
	obj1.setAttribute('name', 'g_seq')
	obj1.setAttribute('value', g_seq)

	f.appendChild(obj1)

	obj2 = document.createElement('input');
	obj2.setAttribute('type', 'hidden')
	obj2.setAttribute('name', 'apt_name')
	obj2.setAttribute('value', apt_name)
	f.appendChild(obj2);

	f.setAttribute('method', 'post');
	f.setAttribute('action', 'goodsInfo.do')
	document.body.appendChild(f);
	f.submit();
}



function saleList() {
	var user_id = $('#user_id').val();
	$("#sale").css("background-color", "black");
	$("#finish").css("background-color", "unset");

	$.ajax({

		url: 'goodsSale.do',
		type: 'post',
		data: {

			'user_id': user_id

		},
		success: list,
		error: function() {
			console.log("판매중 실패")
		}


	})

}

function finishList() {
	var user_id = $('#user_id').val();
	$("#sale").css("background-color", "unset");
	$("#finish").css("background-color", "black");


	$.ajax({

		url: "goodsFinishList.do",
		type: 'post',
		data: {
			'user_id': user_id
		},
		success: list,
		error: function() {
			console.log("판매완료 실패")
		}


	})

}

function list(data) {

	console.log(data)
	$("#printlist").html("");

	var list = "";

	if (data.length == 0) {

		list = ` <div class="empty-list">
					<p>판매 내역이 없어요.</p>
				</div>`
		
		$(".navbar").after(list);
		$("body").css("background-color", "#4c4c4c1c")

	} else {

		$(".empty-list").html("");
		$("body").css("background-color", "white")
		
		for (let i = 0; i < data.length; i++) {
			var vo = data[i]
			console.log(vo.g_name)
			list = `<div id="product-list">
							<div class="card-product__img"
								onclick="viewGoodsContent(${vo.g_seq})">
								<img class="card-img" src="file/${vo.g_img}">
								<div class="card-body">
									<h4>
										${vo.g_name}
									</h4>
									<br>
									<div class="pr-zzim">
										<p class="price">
											${vo.g_price}
										</p>
										<div class="zzim-div" onclick="">
											<img class="zzim" src="/img/icon/star-empty.png">
											<p class="zzim-cnt">${vo.wish_cnt}</p>
										</div>
									</div>
							</div>
						</div>
							<div class="update-sec">
								<button class="btn btn-sm update" onclick="findGoodsPw()">비밀번호확인</button>
								<button class="btn btn-sm update" type="button"
									onclick="updateGoods()">수정하기</button>
								<button class="btn btn-sm update"
									onclick="deleteGoods(${vo.g_seq})">삭제하기</button>
							</div>
							<div class="goods-line"></div>
					`
			$("#printlist").append(list);

		}
	}

}

function deleteGoods(g_seq) {

	$.ajax({

		url: "goodsDelete.do",
		type: "post",
		data: {
			"g_seq": g_seq
		},
		success: list,

		error: function() {
			alert("실패")
		}
	})

}