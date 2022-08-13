$(document).ready(loadFooter)

function loadFooter() {

	$(".foot-bar").html("");

	list = `<div class="foot-div" onclick="location.href='index.do'">
			<div>
				<img alt="" src="/img/icon/home-gr.png">
			</div>
		</div>

		<div class="foot-div" onclick="location.href='postList.do'">
			<div>
				<img alt="" src="/img/icon/community-gr.png">
			</div>
		</div>

		<div class="foot-div" onclick="location.href='viewChallenge.do'">
			<img class=" main-btn" alt="" src="/img/icon/earth.png">
		</div>

		<div class="foot-div">
			<img alt="" src="/img/icon/message-gr.png">
		</div>
		<div class="foot-div" onclick="location.href='viewMypage.do'">
			<img alt="" src="/img/icon/me-gr2.png">
		</div>`

	$(".foot-bar").html(list);

}
