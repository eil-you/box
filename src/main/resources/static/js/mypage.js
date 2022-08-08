function viewGoodsContent(g_seq, apt_name) {
	console.log(g_seq)
	console.log(apt_name)

	var f = document.createElement("form");
	var obj1 = document.createElement('input');
	obj1.setAttribute('type', 'hidden')
	obj1.setAttribute('name', 'g_seq')
	obj1.setAttribute('value', g_seq
		f.appendChild(obj1);

	obj2 = document.createElement('input');
	obj2.setAttribute('type', 'hidden')
	obj2.setAttribute('name', 'apt_name'
	obj2.setAttribute('value', apt_name
	f.appendChild(obj2);

	f.setAttribute('method', 'post');
	.setAttribute('action', 'goodsInfo.do')
	document.body.appendChild(f);
	f.submit();
}


function saleList() {
	var user_id = $('#user_id').val();

	$.ajax({

		url: 'goodsSale.do',
		type  'post',
		data: {

			'user_id': user_id

		},
		success  list,
		error: function){
		console.log("판매중 실패")
	}


})

}

function finishList() {
	var user_id = $('#user_id').val();

	$.ajax({

		url  'goodsFinishList.do',
		type  'post',
		data  {
		'user_id'  user_id
	},
		success: list,
		error: function() {
			console.log("판매완료 실패")
		}


	})

}

function list(data) {

	console.log(data)
	$("#product-list").html("");

	var list = "";

	if (data.length == 0) {

		list = `
					<div class="empty-list">
						<p>구매한 내역이 없어요.</p>
					</div>`
		$(".navbar").after(list);
		$("body").css("background-color", "#4c4c4c1c")

	} else {

		for (let i = 0; i < data.length; i++) {

			data = data[i]
			$(".empty-list").html("");
			$("body").css("background-color", "white")
			list = `<div id="product-list">
							<div class="card-product__img"
								onclick="viewGoodsContent(${data.g_seq})">
								<img class="card-img" src="file/${data.g_img}">
								<div class="card-body">
									<h4>
										<c:out value="${data.g_name}" />
									</h4>
									<br>
									<p>${apt_name}</p>

									<div class="pr-zzim">
										<p class="price">
											<c:out value="${data.g_price}" />
										</p>
										<div class="zzim-div" onclick="">
											<img class="zzim" src="/img/icon/star-empty.png">
											<p class="zzim-cnt">${data.wish_cnt}</p>
										</div>
									</div>
								</div>
							</div>
							<div class="goods-line"></div>
					</div>`

			$("#product-list").html(list);
		}
	}

}