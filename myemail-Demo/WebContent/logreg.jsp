<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Home , Email</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="" />
<meta name="keywords" content="" />
<meta name="author" content="" />
<link href="assets/img/sam.ico" rel="shortcut icon" type="image/x-icon" />

<link rel="stylesheet" href="css/animate.css">
<link rel="stylesheet" href="css/icomoon.css">
<link rel="stylesheet" href="css/themify-icons.css">
<link rel="stylesheet" href="assets/css/bootstrap.css">
<!-- Magnific Popup -->
<link rel="stylesheet" href="css/magnific-popup.css">
<!-- Owl Carousel  -->
<link rel="stylesheet" href="css/owl.carousel.min.css">
<link rel="stylesheet" href="css/owl.theme.default.min.css">
<!-- Theme style  -->
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/logreg.css" />
<!-- Modernizr JS -->
<script src="js/modernizr-2.6.2.min.js"></script>
<script >alert("Some features are perfect, so stay tuned")</script>
<!-- FOR IE9 below -->
<!--[if lt IE 9]>
    <script src="js/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<script type="text/javascript"><%=request.getAttribute("errormsg") %></script>
	<div class="gtco-loader"></div>
	<div id="page">
		<div class="page-inner">
			<nav class="gtco-nav" role="navigation">
				<div class="gtco-container">

					<div class="row">
						<div class="col-sm-4 col-xs-12">
							<div id="gtco-logo">
								<a href="index.jsp">TLLZH <em>.</em></a>
							</div>
						</div>
						<div class="col-xs-8 text-right menu-1">
							<ul>
								<li><a href="javascript:void(0)">Features</a></li>
								<li><a href="javascript:void(0)">Tour</a></li>
								<li class="has-dropdown"><a href="#">Dropdown</a>
									<ul class="dropdown">
										<li><a href="#">Web Design</a></li>
										<li><a href="#">eCommerce</a></li>
										<li><a href="#">Branding</a></li>
										<li><a href="#">API</a></li>
									</ul></li>
								<li><a href="javascript:void(0)">Pricing</a></li>
								<li><a href="contact.html">Contact</a></li>
								<li class="btn-cta"><a href="index.html"><span>Get
											started</span></a></li>
							</ul>
						</div>
					</div>

				</div>
			</nav>

			<header id="gtco-header" class="gtco-cover" role="banner"
				style="background-image: url(images/img_4.jpg)">
				<div class="overlay"></div>
				<div class="gtco-container">
					<div class="row">
						<div class="col-md-12 col-md-offset-0 text-left">


							<div class="row row-mt-15em">
								<div class="col-md-7 mt-text animate-box"
									data-animate-effect="fadeInUp">
									<span class="intro-text-small">Welcome to TLLZH</span>
									<h1>If you like this website please promote it.</h1>
								</div>
								<div class="col-md-4 col-md-push-1 animate-box"
									data-animate-effect="fadeInRight">
									<div class="form-wrap">
										<div class="tab">
											<ul class="tab-menu">
												<li class="active gtco-first"><a href="#"
													data-tab="signup">Sign up</a></li>
												<li class="gtco-second"><a href="#" data-tab="login">Login</a></li>
											</ul>
											<div class="tab-content">
												<div class="tab-content-inner active" data-content="signup">
													<form action="register" method="post" id="registerform">
													 <input type="hidden" name="token" value="${token}"/>
														<div class="row form-group2">
															<div class="col-md-12">
																<label for="username">Username</label> <input
																	type="text" class="form-control" id="username"
																	name="username" autocomplete="off">
																<p class="prompt prompt-posi"></p>
															</div>
														</div>
														<div class="row form-group2">
															<div class="col-md-12">
																<label for="Email">Email</label> <input type="text"
																	class="form-control" id="email" name="email"
																	autocomplete="off">
																<p class="prompt prompt-posi"></p>
															</div>
														</div>

														<div class="row form-group2">
															<div class="col-md-12">
																<label for="password">Password</label> <input
																	type="password" class="form-control" id="password"
																	name="password" autocomplete="off">
																<p class="prompt prompt-posi"></p>
															</div>
														</div>
														<div class="row form-group2">
															<div class="col-md-12">
																<label for="pwdAGAIN">Repeat Password</label> <input
																	type="password" class="form-control" id="pwdAGAIN"
																	name="pwdAGAIN" autocomplete="off">
																<p class="prompt prompt-posi"></p>
															</div>
														</div>

														<div class="row form-group2">
															<div class="col-md-7" style="float: left;">
																<label for="code">Verification code</label> <input
																	type="text" class="form-control" id="code" name="code"
																	autocomplete="off">
																<p class="prompt prompt-posi"></p>
															</div>
															<div class="col-md-5"
																style="padding-left: 0px; float: left;">
																<label for="">&nbsp;</label><br /> <input
																	class="btn-cta btn" type="button" value="Get Code"
																	style="padding: 6px 20px;" id="getLOGCODE">
															</div>
															<div class="clearfix"></div>
														</div>

														<div class="row form-group" style="margin-top:15px">
															<div class="col-md-12">
																<input type="submit" class="btn btn-primary"
																	value="Sign up">
															</div>
														</div>
													</form>
												</div>

												<div class="tab-content-inner" data-content="login">
													<form action="login" method="post" id="loginform">
													<input type="hidden" name="token" value="${token}"/>
														<div class="row form-group">
															<div class="col-md-12">
																<label for="loginname">Username or Email</label> <input
																	type="text" class="form-control" id="loginname"
																	name="username" autocomplete="off">
																<p class="prompt prompt-posi"></p>
															</div>
														</div>
														<div class="row form-group">
															<div class="col-md-12">
																<label for="loginpassword">Password</label> <input
																	type="password" class="form-control" id="loginpassword"
																	name="password" autocomplete="off">
																<p class="prompt prompt-posi"></p>
															</div>
														</div>

														<div class="row form-group">
															<div class="col-md-12">
																<input type="submit" class="btn btn-primary"
																	value="Login" id="tologin">
															</div>
														</div>
													</form>
												</div>

											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</header>

			<div class="gtco-section border-bottom">
				<div class="gtco-container">
					<div class="row">
						<div class="col-md-8 col-md-offset-2 text-center gtco-heading">
							<h2>Beautiful Images</h2>
							<p>Dignissimos asperiores vitae velit veniam totam fuga
								molestias accusamus alias autem provident. Odit ab aliquam dolor
								eius.</p>
						</div>
					</div>
					<div class="row">
						<div class="col-lg-4 col-md-4 col-sm-6">
							<a href="images/img_2.jpg" class="fh5co-project-item image-popup">
								<figure>
									<div class="overlay">
										<i class="ti-plus"></i>
									</div>
									<img src="images/img_2.jpg" alt="Image" class="img-responsive">
								</figure>
								<div class="fh5co-text">
									<h2>Constructive heading</h2>
									<p>Far far away, behind the word mountains, far from the
										countries Vokalia..</p>
								</div>
							</a>
						</div>
						<div class="col-lg-4 col-md-4 col-sm-6">
							<a href="images/img_3.jpg" class="fh5co-project-item image-popup">
								<figure>
									<div class="overlay">
										<i class="ti-plus"></i>
									</div>
									<img src="images/img_3.jpg" alt="Image" class="img-responsive">
								</figure>
								<div class="fh5co-text">
									<h2>Constructive heading</h2>
									<p>Far far away, behind the word mountains, far from the
										countries Vokalia..</p>
								</div>
							</a>
						</div>
						<div class="col-lg-4 col-md-4 col-sm-6">
							<a href="images/img_4.jpg" class="fh5co-project-item image-popup">
								<figure>
									<div class="overlay">
										<i class="ti-plus"></i>
									</div>
									<img src="images/img_4.jpg" alt="Image" class="img-responsive">
								</figure>
								<div class="fh5co-text">
									<h2>Constructive heading</h2>
									<p>Far far away, behind the word mountains, far from the
										countries Vokalia..</p>
								</div>
							</a>
						</div>

						<div class="col-lg-4 col-md-4 col-sm-6">
							<a href="images/img_1.jpg" class="fh5co-project-item image-popup">
								<figure>
									<div class="overlay">
										<i class="ti-plus"></i>
									</div>
									<img src="images/img_1.jpg" alt="Image" class="img-responsive">
								</figure>
								<div class="fh5co-text">
									<h2>Constructive heading</h2>
									<p>Far far away, behind the word mountains, far from the
										countries Vokalia..</p>
								</div>
							</a>
						</div>
						<div class="col-lg-4 col-md-4 col-sm-6">
							<a href="images/img_5.jpg" class="fh5co-project-item image-popup">
								<figure>
									<div class="overlay">
										<i class="ti-plus"></i>
									</div>
									<img src="images/img_5.jpg" alt="Image" class="img-responsive">
								</figure>
								<div class="fh5co-text">
									<h2>Constructive heading</h2>
									<p>Far far away, behind the word mountains, far from the
										countries Vokalia..</p>
								</div>
							</a>
						</div>
						<div class="col-lg-4 col-md-4 col-sm-6">
							<a href="images/img_6.jpg" class="fh5co-project-item image-popup">
								<figure>
									<div class="overlay">
										<i class="ti-plus"></i>
									</div>
									<img src="images/img_6.jpg" alt="Image" class="img-responsive">
								</figure>
								<div class="fh5co-text">
									<h2>Constructive heading</h2>
									<p>Far far away, behind the word mountains, far from the
										countries Vokalia..</p>
								</div>
							</a>
						</div>

					</div>
				</div>
			</div>



			<footer id="gtco-footer" role="contentinfo">
				<div class="gtco-container">
					<div class="row row-p   b-md">

						<div class="col-md-4">
							<div class="gtco-widget">
								<h3>
									About <span class="footer-logo">TLLZH<span>.<span></span>
								</h3>
								<p>This website is just a personal website. If there is any
									infringement, please contact me. If you have an imperfect
									place, you can also contact us by email. thanks for your
									support</p>
							</div>
						</div>

						<div class="col-md-4 col-md-push-1">
							<div class="gtco-widget">
								<h3>Links</h3>
								<ul class="gtco-footer-links">
									<li><a href="#">Knowledge Base</a></li>
									<li><a href="#">Career</a></li>
									<li><a href="#">Press</a></li>
									<li><a href="#">Terms of services</a></li>
									<li><a href="#">Privacy Policy</a></li>
								</ul>
							</div>
						</div>

						<div class="col-md-4">
							<div class="gtco-widget">
								<h3>Get In Touch</h3>
								<ul class="gtco-quick-contact">
									<li><a href="#"><i class="icon-phone"></i>
											+13144701062</a></li>
									<li><a href="#"><i class="icon-mail2"></i> info@</a></li>
									<li><a href="#"><i class="icon-chat"></i> Live Chat</a></li>
								</ul>
							</div>
						</div>

					</div>

					<div class="row copyright">
						<div class="col-md-12">
							<p class="pull-left">
								<small class="block">Copyright &copy; 2019.Personal name
									reserves all rights.</small>
									All interpretation rights on this website are explained by the developer
							</p>
						</div>
					</div>

				</div>
			</footer>
		</div>

	</div>

	<div class="gototop js-top">
		<a href="#" class="js-gotop"><i class="icon-arrow-up"></i></a>
	</div>

	<script src="assets/js/jquery-1.8.3.min.js"></script>
	<script src="js/jquery.easing.1.3.js"></script>
	<!-- Bootstrap -->
	<script src="js/bootstrap.min.js"></script>
	<!-- Waypoints -->
	<script src="js/jquery.waypoints.min.js"></script>
	<!-- Carousel -->
	<script src="js/owl.carousel.min.js"></script>
	<!-- Magnific Popup -->
	<script src="js/jquery.magnific-popup.min.js"></script>
	<script src="js/magnific-popup-options.js"></script>
	<!-- Main -->
	<script src="js/main.js"></script>
	<script src="js/formatverification.js"></script>

</body>
</html>

