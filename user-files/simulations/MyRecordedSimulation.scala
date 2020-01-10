package tutorial

import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class MyRecordedSimulation extends Simulation {

	val httpProtocol = http
		.baseUrl("http://automationpractice.com")
		.disableFollowRedirect
		.disableAutoReferer
		.acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
		.acceptEncodingHeader("gzip, deflate")
		.acceptLanguageHeader("pl,en-US;q=0.7,en;q=0.3")
		.userAgentHeader("Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:71.0) Gecko/20100101 Firefox/71.0")

	val headers_0 = Map(
		"Cache-Control" -> "max-age=0",
		"Referer" -> "http://automationpractice.com/index.php",
		"Upgrade-Insecure-Requests" -> "1")

	val headers_1 = Map(
		"Accept" -> "*/*",
		"Cache-Control" -> "no-cache",
		"Pragma" -> "no-cache")

	val headers_4 = Map(
		"Accept" -> "text/css,*/*;q=0.1",
		"Accept-Encoding" -> "gzip, deflate, br",
		"Cache-Control" -> "max-age=0",
		"Referer" -> "http://automationpractice.com/index.php")

	val headers_5 = Map(
		"Accept" -> "*/*",
		"Accept-Encoding" -> "gzip, deflate, br",
		"Origin" -> "http://automationpractice.com",
		"Referer" -> "http://automationpractice.com/index.php")

	val headers_6 = Map(
		"Accept" -> "*/*",
		"Accept-Encoding" -> "gzip, deflate, br",
		"Origin" -> "http://automationpractice.com",
		"Referer" -> "http://automationpractice.com/")

	val headers_7 = Map(
		"Accept" -> "application/json, text/javascript, */*; q=0.01",
		"Referer" -> "http://automationpractice.com/index.php",
		"X-Requested-With" -> "XMLHttpRequest")

	val headers_9 = Map(
		"Referer" -> "http://automationpractice.com/index.php",
		"Upgrade-Insecure-Requests" -> "1")

	val headers_10 = Map(
		"Referer" -> "http://automationpractice.com/index.php?controller=search&orderby=position&orderway=desc&search_query=dress&submit_search=",
		"Upgrade-Insecure-Requests" -> "1")

	val headers_11 = Map(
		"Accept" -> "application/json, text/javascript, */*; q=0.01",
		"Content-Type" -> "application/x-www-form-urlencoded; charset=UTF-8",
		"Origin" -> "http://automationpractice.com",
		"Referer" -> "http://automationpractice.com/index.php?id_product=7&controller=product",
		"X-Requested-With" -> "XMLHttpRequest",
		"cache-control" -> "no-cache")

	val headers_12 = Map(
		"Referer" -> "http://automationpractice.com/index.php?id_product=7&controller=product",
		"Upgrade-Insecure-Requests" -> "1")

	val headers_13 = Map(
		"Referer" -> "http://automationpractice.com/index.php?controller=order",
		"Upgrade-Insecure-Requests" -> "1")

	val headers_18 = Map(
		"Origin" -> "http://automationpractice.com",
		"Referer" -> "http://automationpractice.com/index.php?controller=authentication&multi-shipping=0&display_guest_checkout=0&back=http%3A%2F%2Fautomationpractice.com%2Findex.php%3Fcontroller%3Dorder%26step%3D1%26multi-shipping%3D0",
		"Upgrade-Insecure-Requests" -> "1")

	val headers_19 = Map(
		"Referer" -> "http://automationpractice.com/index.php?controller=authentication&multi-shipping=0&display_guest_checkout=0&back=http%3A%2F%2Fautomationpractice.com%2Findex.php%3Fcontroller%3Dorder%26step%3D1%26multi-shipping%3D0",
		"Upgrade-Insecure-Requests" -> "1")

	val headers_20 = Map(
		"Origin" -> "http://automationpractice.com",
		"Referer" -> "http://automationpractice.com/index.php?controller=order&step=1&multi-shipping=0",
		"Upgrade-Insecure-Requests" -> "1")

	val headers_21 = Map(
		"Origin" -> "http://automationpractice.com",
		"Referer" -> "http://automationpractice.com/index.php?controller=order",
		"Upgrade-Insecure-Requests" -> "1")

	val headers_22 = Map(
		"Referer" -> "http://automationpractice.com/index.php?controller=order&multi-shipping=",
		"Upgrade-Insecure-Requests" -> "1")

	val headers_23 = Map(
		"Origin" -> "http://automationpractice.com",
		"Referer" -> "http://automationpractice.com/index.php?fc=module&module=bankwire&controller=payment",
		"Upgrade-Insecure-Requests" -> "1")

	val headers_24 = Map(
		"Referer" -> "http://automationpractice.com/index.php?fc=module&module=bankwire&controller=payment",
		"Upgrade-Insecure-Requests" -> "1")

    val uri1 = "https://connect.facebook.net:443/en_US/all.js"
    val uri2 = "https://www.facebook.com:443/x/oauth/status"
    val uri4 = "http://detectportal.firefox.com/success.txt"
    val uri5 = "fonts.googleapis.com"

	val scn = scenario("RecordedSimulation")
		.exec(http("request_0")
			.get("/index.php")
			.headers(headers_0))
		.pause(333 milliseconds)
		.exec(http("request_1")
			.get(uri4 + "")
			.headers(headers_1))
		.exec(http("request_2")
			.get(uri4 + "?ipv4")
			.headers(headers_1))
		.exec(http("request_3")
			.get(uri4 + "?ipv6")
			.headers(headers_1))
		.exec(http("request_4")
			.get("https://" + uri5 + ":443/css?family=Open+Sans:300,600&subset=latin,latin-ext")
			.headers(headers_4))
		.pause(4)
		.exec(http("request_5")
			.get(uri1 + "?hash=a17f20a15b721a85de37dccc09319252")
			.headers(headers_5))
		.pause(372 milliseconds)
		.exec(http("request_6")
			.get(uri2 + "?client_id=334341610034299&input_token&origin=1&redirect_uri=http%3A%2F%2Fautomationpractice.com%2Findex.php&sdk=joey&wants_cookie_data=false")
			.headers(headers_6))
		.pause(3)
		.exec(http("request_7")
			.get("/index.php?controller=search&q=dres&limit=10&timestamp=1576956190502&ajaxSearch=1&id_lang=1")
			.headers(headers_7))
		.pause(196 milliseconds)
		.exec(http("request_8")
			.get("/index.php?controller=search&q=dress&limit=10&timestamp=1576956191346&ajaxSearch=1&id_lang=1")
			.headers(headers_7))
		.pause(527 milliseconds)
		.exec(http("request_9")
			.get("/index.php?controller=search&orderby=position&orderway=desc&search_query=dress&submit_search=")
			.headers(headers_9))
		.pause(5)
		.exec(http("request_10")
			.get("/index.php?id_product=7&controller=product")
			.headers(headers_10))
		.pause(9)
		.exec(http("request_11")
			.post("/index.php?rand=1576956212168")
			.headers(headers_11)
			.formParam("controller", "cart")
			.formParam("add", "1")
			.formParam("ajax", "true")
			.formParam("qty", "1")
			.formParam("id_product", "7")
			.formParam("token", "e817bb0705dd58da8db074c69f729fd8")
			.formParam("ipa", "34"))
		.pause(1)
		.exec(http("request_12")
			.get("/index.php?controller=order")
			.headers(headers_12))
		.pause(6)
		.exec(http("request_13")
			.get("/index.php?controller=order&step=1")
			.headers(headers_13)
			.check(status.is(302)))
		.exec(http("request_14")
			.get("/index.php?controller=authentication&multi-shipping=0&display_guest_checkout=0&back=http%3A%2F%2Fautomationpractice.com%2Findex.php%3Fcontroller%3Dorder%26step%3D1%26multi-shipping%3D0")
			.headers(headers_13))
		.pause(17)
		.exec(http("request_15")
			.get(uri4 + "")
			.headers(headers_1))
		.exec(http("request_16")
			.get(uri4 + "?ipv4")
			.headers(headers_1))
		.exec(http("request_17")
			.get(uri4 + "?ipv6")
			.headers(headers_1))
		.pause(9)
		.exec(http("request_18")
			.post("/index.php?controller=authentication")
			.headers(headers_18)
			.formParam("email", "d6403887@urhen.com")
			.formParam("passwd", "test123")
			.formParam("back", "http://automationpractice.com/index.php?controller=order&step=1&multi-shipping=0")
			.formParam("SubmitLogin", "")
			.check(status.is(302)))
		.exec(http("request_19")
			.get("/index.php?controller=order&step=1&multi-shipping=0")
			.headers(headers_19))
		.pause(8)
		.exec(http("request_20")
			.post("/index.php?controller=order")
			.headers(headers_20)
			.formParam("id_address_delivery", "248877")
			.formParam("same", "1")
			.formParam("message", "")
			.formParam("step", "2")
			.formParam("back", "")
			.formParam("processAddress", ""))
		.pause(5)
		.exec(http("request_21")
			.post("/index.php?controller=order&multi-shipping=")
			.headers(headers_21)
			.formParam("delivery_option[248877]", "2,")
			.formParam("cgv", "1")
			.formParam("step", "3")
			.formParam("back", "")
			.formParam("processCarrier", ""))
		.pause(3)
		.exec(http("request_22")
			.get("/index.php?fc=module&module=bankwire&controller=payment")
			.headers(headers_22))
		.pause(3)
		.exec(http("request_23")
			.post("/index.php?fc=module&module=bankwire&controller=validation")
			.headers(headers_23)
			.formParam("currency_payement", "1")
			.check(status.is(302)))
		.exec(http("request_24")
			.get("/index.php?controller=order-confirmation&id_cart=1471161&id_module=3&id_order=154287&key=57d0627de3b5d408346f0e1d3996430e")
			.headers(headers_24))

	setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
}