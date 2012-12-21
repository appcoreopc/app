<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<link href="css/header.css" media="screen" rel="stylesheet" type="text/css" />
<link href="css/default.css" media="screen" rel="stylesheet" type="text/css" />

<script language="javascript" src="js/jquery-1.7.2.min.js"></script>
<script language="javascript" src="js/carousel.js"></script>


<div class="navbar navbar-top class" id="header">
  <div class="navbar-inner">
    <div class="container">
      <a class="brand airbnb" href="/">Airbnb</a>

      <ul class="nav logged-out">
        <li><a href="app_dev.php/HowItWork	">How It Works</a>
        </li><li class="divider-vertical">
        </li><li><a href="/signup_login">Sign Up</a>
        </li><li class="divider-vertical">
        </li><li><a href="/login">Log In</a>
        </li><li class="wishlist-nav divider-vertical">
        </li><li class="wishlist-nav"><a href="/wishlists"><i class="heart">0</i> Wish Lists</a>
      </li></ul>

      <ul class="nav logged-in">
        <li class="dropdown">
          <a href="javascript:void(0)" class="dropdown-toggle">
            <i class="user"></i>
            Hi, <span class="value_name">User</span>! <b class="caret"></b>
          </a>
          <ul class="dropdown-menu">
            <li><a href="/home/dashboard">Dashboard</a>
            </li><li>
              <a href="/rooms">
                <span style="display: none;" class="singular">Your Listing</span>
                <span class="plural">Your Listings</span>
              </a>
            </li>
            <li><a href="/trips/upcoming">Your Trips</a>
            </li><li class="divider">
            </li><li><a href="/users/show">Profile</a>
            </li><li><a href="/account">Account</a>
            </li><li>
              <a onclick="var f = document.createElement('form'); f.style.display = 'none'; this.parentNode.appendChild(f); f.method = 'POST'; f.action = this.href;f.submit();return false;" href="/logout">Log Out</a>
            </li>
          </ul>
        </li>
        <li class="divider-vertical">
        </li><li><a href="/home/inbox"><i class="mail">Mail</i><i class="alert-count fade">0</i></a>
        </li><li class="divider-vertical">
        </li><li class="button_wish_list"><a href="/wishlists"><i class="heart">0</i> Wish Lists</a>
      </li></ul>

      <ul class="nav pull-right">
        <li class="dropdown">
          <a href="javascript:void(0)" class="dropdown-toggle help-toggle">
            24/7 Support <b class="caret"></b>
          </a>
          <ul class="dropdown-menu help-dropdown">
            <li class="nav-header">Need help on this page? <a class="lighter small right unstyled help-center-link hidden" href="/help">Visit the Help Center</a>
            </li><li class="loading"></li>
            <li class="all_faqs mt10 hidden"><a href="/help/topic/hosting">See all FAQs</a></li>
            <li class="nav-custom blue hidden">
              <form method="get" action="/help/search" accept-charset="UTF-8">
                <div style="margin:0;padding:0;display:inline"><input type="hidden" value="?" name="utf8"></div>
                <input type="text" role="textbox" placeholder="Search Help" name="q" id="q" class="search-input">
                <button class="btn blue only-icon" type="submit">
                  <i class="icon-search"></i>
                </button>
              </form>
            </li>
          </ul>
        </li>
        <li class="divider-vertical">
        </li><li class="dropdown">
          <a href="javascript:void(0)" class="dropdown-toggle">
            <i class="globe"></i> <span class="value_language">English</span> <b class="caret"></b>
          </a>
          <ul class="dropdown-menu language-dropdown">
            <li class="nav-header">Choose language
              </li><li data-locale="da" id="language_selector_da"><a href="javascript:void(0);">Dansk</a></li>
              <li data-locale="de" id="language_selector_de"><a href="javascript:void(0);">Deutsch</a></li>
              <li data-locale="es" id="language_selector_es"><a href="javascript:void(0);">Español</a></li>
              <li data-locale="fr" id="language_selector_fr"><a href="javascript:void(0);">Français</a></li>
              <li data-locale="it" id="language_selector_it"><a href="javascript:void(0);">Italiano</a></li>
              <li data-locale="hu" id="language_selector_hu"><a href="javascript:void(0);">Magyar</a></li>
              <li data-locale="pl" id="language_selector_pl"><a href="javascript:void(0);">Polski</a></li>
              <li data-locale="pt" id="language_selector_pt"><a href="javascript:void(0);">Português</a></li>
              <li data-locale="cs" id="language_selector_cs"><a href="javascript:void(0);">Ceština</a></li>
              <li data-locale="ru" id="language_selector_ru"><a href="javascript:void(0);">???????</a></li>
              <li data-locale="zh" id="language_selector_zh"><a href="javascript:void(0);">??(??)</a></li>
              <li data-locale="ko" id="language_selector_ko"><a href="javascript:void(0);">???</a></li>
          </ul>
        </li>
        <li class="divider-vertical">
        </li><li class="dropdown">
          <a href="javascript:void(0)" class="dropdown-toggle">
            <i id="currency_header_icon" class="currency USD dark EUR"></i> <span class="value_currency">EUR</span> <b class="caret"></b>
          </a>
          <ul class="dropdown-menu currency-dropdown">
            <li class="nav-header">Choose currency
            </li><li data-currency="ARS" id="currency_selector_ARS"><a href="javascript:void(0);"><i class="currency ARS dark"></i> ARS</a>
            </li><li data-currency="AUD" id="currency_selector_AUD"><a href="javascript:void(0);"><i class="currency AUD dark"></i> AUD</a>
            </li><li data-currency="BRL" id="currency_selector_BRL"><a href="javascript:void(0);"><i class="currency BRL dark"></i> BRL</a>
            </li><li data-currency="CAD" id="currency_selector_CAD"><a href="javascript:void(0);"><i class="currency CAD dark"></i> CAD</a>
            </li><li data-currency="CHF" id="currency_selector_CHF"><a href="javascript:void(0);"><i class="currency CHF dark"></i> CHF</a>
            </li><li data-currency="CZK" id="currency_selector_CZK"><a href="javascript:void(0);"><i class="currency CZK dark"></i> CZK</a>
            </li><li data-currency="DKK" id="currency_selector_DKK"><a href="javascript:void(0);"><i class="currency DKK dark"></i> DKK</a>
            </li><li data-currency="EUR" id="currency_selector_EUR"><a href="javascript:void(0);"><i class="currency EUR dark"></i> EUR</a>
            </li><li data-currency="GBP" id="currency_selector_GBP"><a href="javascript:void(0);"><i class="currency GBP dark"></i> GBP</a>
            </li><li data-currency="HKD" id="currency_selector_HKD"><a href="javascript:void(0);"><i class="currency HKD dark"></i> HKD</a>
            </li><li data-currency="HUF" id="currency_selector_HUF"><a href="javascript:void(0);"><i class="currency HUF dark"></i> HUF</a>
            </li><li data-currency="ILS" id="currency_selector_ILS"><a href="javascript:void(0);"><i class="currency ILS dark"></i> ILS</a>
            </li><li data-currency="INR" id="currency_selector_INR"><a href="javascript:void(0);"><i class="currency INR dark"></i> INR</a>
            </li><li data-currency="JPY" id="currency_selector_JPY"><a href="javascript:void(0);"><i class="currency JPY dark"></i> JPY</a>
            </li><li data-currency="MXN" id="currency_selector_MXN"><a href="javascript:void(0);"><i class="currency MXN dark"></i> MXN</a>
            </li><li data-currency="NOK" id="currency_selector_NOK"><a href="javascript:void(0);"><i class="currency NOK dark"></i> NOK</a>
            </li><li data-currency="NZD" id="currency_selector_NZD"><a href="javascript:void(0);"><i class="currency NZD dark"></i> NZD</a>
            </li><li data-currency="PLN" id="currency_selector_PLN"><a href="javascript:void(0);"><i class="currency PLN dark"></i> PLN</a>
            </li><li data-currency="RUB" id="currency_selector_RUB"><a href="javascript:void(0);"><i class="currency RUB dark"></i> RUB</a>
            </li><li data-currency="SEK" id="currency_selector_SEK"><a href="javascript:void(0);"><i class="currency SEK dark"></i> SEK</a>
            </li><li data-currency="USD" id="currency_selector_USD"><a href="javascript:void(0);"><i class="currency USD dark"></i> USD</a>
            </li><li data-currency="ZAR" id="currency_selector_ZAR"><a href="javascript:void(0);"><i class="currency ZAR dark"></i> ZAR</a>
          </li></ul>
        </li>
        <li><a href="/rooms/new" class="yellow btn" id="list-your-space">List your space</a></li>
      </ul>
    </div>
  </div>
</div>



<script type="text/javascript">                                         
   
   function Users()
   {
		this.Nid; 
		this.Username; 
		this.Password;
		this.LastLogin; 
		
   }
   
   //var user = new Users(); 
   //user.Username = "Jeremy"; 
   //alert(user.Username);
   
   
   $(document).ready(function() {
   $("#loginBtn").click(function() 
   {
    
	var request = $.ajax({
	// url: "http://localhost:8080/appCore-personnel/krams/Users/Users/add",
	url: "http://localhost:8080/appCore-personnel/krams/Users/Users/get",
	type: "GET",
	// data: user,
	data : { id : 1 }, 
	dataType: "json"
	});

	request.done(function(msg) {
			alert(msg.username);
	});

   });
 });
   
 </script>    

<div> 
<div> 
username : <input type="text" id="username" name="username" value="" /> 
</div> 
<div> 
password : <input type="text" id="password" name="password" value="" /> 
</div> 

<button type="button" id="loginBtn">Login</button>
</div> 

<div class="container">
      <div class="row" id="footer">
        <div class="span3">
          <h5>Explore</h5>
          <ul class="footer-links unstyled">
            <li><a href="/wishlists/airbnb_picks">Airbnb Picks</a></li>
            <li><a href="/mobile">Mobile</a></li>
            <li><a href="http://tv.airbnb.com">Airbnb TV</a></li>
            <li><a href="/safety">Safety</a></li>
          </ul>
        </div>
        <div class="span3">
          <h5>Best deals</h5>
          <ul class="footer-links unstyled">
            <li><a href="/new-york-city">New York</a></li>
            <li><a href="/san-francisco">San Francisco</a></li>
            <li><a href="/paris-france">Paris</a></li>
          </ul>
        </div>
        <div class="span3">
          <h5>Company</h5>
          <ul class="footer-links unstyled">
            <li><a href="/about">About</a></li>
            <li><a href="/jobs">Jobs</a></li>
            <li><a href="http://blog.airbnb.com">Blog</a></li>
            <li><a href="/help">Help</a></li>
            <li><a href="/terms">Terms &amp; Privacy</a></li>
          </ul>
        </div>
        <div class="span3">
          <h5>Join us on</h5>
          <ul class="social-links unstyled">
            <li><a class="twitter" href="http://twitter.com/airbnb">Twitter</a></li> 
            <li><a class="facebook" href="http://www.facebook.com/airbnb">Facebook</a></li> 
            <li><a class="google" href="https://plus.google.com/115781326273917331624">Google</a></li>
            <li><a class="youtube" href="http://www.youtube.com/airbnb">YouTube</a></li> 
          </ul>
        </div>
      </div> 
    </div>

</body>
</html>