<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="Dashboard">
<meta name="keyword"
	content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">

<title>My prank mailbox</title>
<link href="assets/img/sam.ico" rel="shortcut icon" type="image/x-icon" />
<!-- Bootstrap core CSS -->
<link href="assets/css/bootstrap.css" rel="stylesheet">
<!--external css-->
<link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
<link href="css/component.css" rel="stylesheet">
<link href="assets/css/style.css" rel="stylesheet">
<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>
	<script>
		${msg }
	</script>
	<section id="container">
		<header class="header black-bg">
			<div class="sidebar-toggle-box">
				<div class="fa fa-bars tooltips" data-placement="right"
					data-original-title="Toggle Navigation"></div>
			</div>
			<!--logo start-->
			<a href="index.html" class="logo"><b>DASHGUM FREE</b></a>
			<!--logo end-->
			<div class="nav notify-row" id="top_menu">
				<!--  notification start -->
				<ul class="nav top-menu">
					<!-- inbox dropdown start-->
					<li id="header_inbox_bar" class="dropdown"><a
						data-toggle="dropdown" class="dropdown-toggle" href="index.html#">
							<i class="fa fa-envelope-o"></i> <span class="badge bg-theme">5</span>
					</a>
						<ul class="dropdown-menu extended inbox">
							<div class="notify-arrow notify-arrow-green"></div>
							<li>
								<p class="green">You have 5 new messages</p>
							</li>


							<li><a href="index.html#"> <span class="photo"><img
										alt="avatar" src="assets/img/ui-sherman.jpg"></span> <span
									class="subject"> <span class="from">Dj Sherman</span> <span
										class="time">4 hrs.</span>
								</span> <span class="message"> Please, answer asap. </span>
							</a></li>
							<li><a href="index.html#">See all messages</a></li>
						</ul></li>
					<!-- inbox dropdown end -->
				</ul>

			</div>
			<!-- Function Description start -->
			<div class="nav" style="float: left; margin-top: 15px;">
				<ul class="nav top-menu">
					<li id="header_inbox_bar" class="dropdown"><a
						data-toggle="dropdown" class="dropdown-toggle" href="" id="isshow">
							<i class="glyphicon glyphicon-warning-sign"></i>
					</a></li>
				</ul>

			</div>
			<!-- Function Description end -->
			<div class="top-menu">
				<ul class="nav pull-right top-menu">
					<li><a class="logout" href="javascript:void(0)" id="logout">Logout</a></li>
				</ul>
			</div>
		</header>

		<!--sidebar start-->
		<aside>
			<div id="sidebar" class="nav-collapse ">
				<!-- sidebar menu start-->
				<ul class="sidebar-menu" id="nav-accordion">
					<p class="centered">
						<a href="javascript:0;"><img src="assets/img/ui-sams.jpg"
							class="img-circle" width="60"></a>
					</p>
					<h5 class="centered">${UID}</h5>

					<li class="mt"><a href="#"> <i class="fa fa-dashboard"></i>
							<span>gas</span>
					</a></li>


					<li class="sub-menu"><a href="javascript:0;"> <i
							class="fa fa-cogs"></i> <span>Setting</span>
					</a>
						<ul class="sub">
							<li><a href="calendar.html">Account</a></li>
							<li><a href="gallery.html">User information</a></li>
						</ul></li>
					<li class="sub-menu"><a href="javascript:;" class="active">
							<i class="fa fa-book"></i> <span>Send Pages</span>
					</a> <!--  <ul class="sub">
                          <li><a  href="blank.html">Blank Page</a></li>
                          
                      </ul> --></li>
					<li class="sub-menu"><a href="javascript:;"> <i
							class="fa fa-th"></i> <span>Log record</span>
					</a> <!-- <ul class="sub">
                          <li><a  href="basic_table.html">Basic Table</a></li>
                          <li><a  href="responsive_table.html">Responsive Table</a></li>
                      </ul> --></li>

				</ul>
			</div>
		</aside>
		<!--sidebar end-->
		<div class="copyrights">
			Collect from <a href="#"></a>
		</div>

		<!--main content start-->
		<section id="main-content">
			<section class="wrapper">
				<div class="row">
					<div class="col-lg-9 ">
						<div class="posishow">
							<div class="listshow listshowActive">
								<div id="Emailsend">
									<form method="post" action="Sendemail"
										enctype="multipart/form-data" id="SendEmail">
										<header style="padding: 10px;">
											<button class="btn btn-default" type="submit" id="SendEmails">Send</button>
											<button class="btn btn-default" type="button" id="saveEmail">Save
												draft</button>
										</header>
										<div class="row form-group">
											<div class="col-md-2 grouptlable">Recipient</div>
											<div class="col-md-10 inPosi">
												<input type="text" class="form-control" id="recipient"
													name="recipient" autocomplete="off">
												<p class="prompt"></p>
											</div>
										</div>
										<div class="row form-group">
											<div class="col-md-2 grouptlable">Theme</div>
											<div class="col-md-10 inPosi">
												<input type="text" class="form-control" id="theme"
													name="theme">
												<p class="prompt"></p>
											</div>
										</div>
										<div class="row form-group">
											<div class="col-md-2 grouptlable">Add annex</div>
											<div class="col-md-10 inPosi">
												<input type="file" style="display: none; opacity: 0;"
													name="annex">
												<button class="btn openfile" type="button">Select
													file</button>
												<p class="prompt"></p>
											</div>
										</div>

										<div class="row form-group">
											<div class="col-md-2 grouptlable">content</div>
											<div class="col-md-10 inPosi">
												<textarea name="content" id="content"
													class="form-control contentArea">Welcome to the Six apples mailbox</textarea>
												<p class="prompt"></p>
											</div>
										</div>

									</form>
								</div>
							</div>
						</div>
					</div>

					<div class="col-lg-3 ds">
						<h3>Recording</h3>
						<c:if test="${empty recordingLIST}">
							<div class="desc">
								<div class="thumb">
									<span class="badge bg-theme"><i class="fa fa-clock-o"></i></span>
								</div>
								<div class="details">
									<p>
										<a href="javascript:0;">You have not yet sent any records</a>
									</p>
								</div>
							</div>

						</c:if>
						<c:forEach var="Record" items="${recordingLIST }" varStatus="idex">
							<div class="desc">
								<div class="thumb">
									<span class="badge bg-theme"><i class="fa fa-clock-o"></i></span>
								</div>
								<div class="details">
									<p>
										<muted>${Record.rdate }</muted>
										<br /> <a href="javascript:0;">${Record.rtheme }</a><br />
										<c:choose>
											<c:when test="${not empty Record.rminfilename}">A picture</c:when>
											<c:when test="${not empty Record.rbigfile}">An attachment</c:when>
											<c:otherwise>
			                                   No attachment file
			                                </c:otherwise>
										</c:choose>
									</p>
								</div>
							</div>
						</c:forEach>

						<!-- USERS ONLINE SECTION -->
						<h3 id="ishowEight">Send Feedback</h3>
						<h3 id="showDraft">View draft</h3>
						<div id="calendar" class="mb">
							<div class="panel green-panel no-margin"></div>
						</div>
					</div>
				</div>
				</div>
			</section>
		</section>


		<footer class="site-footer">
			<div class="text-center">
				<strong> 2019 - Alvarez.is - LZH Index - Collect from brain<br>
					All interpretation rights on this website are explained by the
					developer
				</strong>
			</div>
		</footer>
		<!--footer end-->
	</section>

	<div class="md-modal md-effect-13" id="modal-13">
		<div class="md-content">
			<h3>Website function description</h3>
			<div>
				<p>Please carefully remember the original intention of this
					website, prohibiting it for illegal use. The consequences of
					violations are borne by themselves. It has nothing to do with
					developers.</p>
				<ul>
					<li><strong>User needs to know:</strong>This website is used
						for small pranks. All emails sent will be sent anonymously. Can be
						sent to close relatives, friends, etc. If you have a bad
						influence, as mentioned above</li>
					<li><strong>Close:</strong>Click anywhere or close the button
						to start your prank</li>
				</ul>
				<button class="md-close btn-sm btn-primary">Close me!</button>
			</div>
		</div>
	</div>
	<div class="md-modal md-effect-8" id="modal-8">
		<div class="md-content" style="background: rgba(0, 0, 0, 0)">
			<div style="position: relative">
				<div id="feedback">
					<div class="section">
						<h6>feedback</h6>
						<p class="message">You can send your valuable comments below.</p>
						<textarea class="feedbackVALUE"></textarea>
						<a class="submit sendFeed" href="javascript:0;">Submit</a>
						<button class="md-closeEight btn-sm btn-primary"
							style="float: right; margin-top: 20px">Close me!</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="md-modal md-effect-9" id="modal-9">
		<div class="md-content">
			<h3>Modal Dialog</h3>
			<div>
				<div class="table-wrapper">
					<table class="fl-table">
						<thead>
							<tr>
								<th>data</th>
								<th>recipient</th>
								<th>theme</th>
							</tr>
						</thead>
						<tbody class="addTbody">
						<tbody>
					</table>
				</div>
				<button class="md-closeNine btn-sm btn-primary">Close me!</button>

			</div>
		</div>
	</div>
	<div class="md-overlay"></div>

	<!-- js placed at the end of the document so the pages load faster -->
	<script src="assets/js/jquery-1.8.3.min.js"></script>
	<script src="assets/js/bootstrap.min.js"></script>
	<script class="include" type="text/javascript"
		src="assets/js/jquery.dcjqaccordion.2.7.js"></script>
	<script src="assets/js/jquery.scrollTo.min.js"></script>
	<script src="assets/js/jquery.nicescroll.js" type="text/javascript"></script>

	<script src="assets/js/common-scripts.js"></script>


</body>
</html>
