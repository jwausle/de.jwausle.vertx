
package html

import play.twirl.api._
import play.twirl.api.TemplateMagic._

import java.lang._
import java.util._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._

/**/
object hello extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template4[java.lang.String,java.lang.String,java.util.Map[java.lang.String, de.jwausle.vertx.Server.Data],de.jwausle.vertx.Server.Data,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(action: java.lang.String
, name:   java.lang.String
, towns:  java.util.Map[java.lang.String,de.jwausle.vertx.Server.Data]
, town:   de.jwausle.vertx.Server.Data
):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*5.2*/("""

"""),format.raw/*7.1*/("""<html>
<title>vertx with play and angularjs(later)</title>
<script src="https://code.jquery.com/jquery-1.11.2.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/ol3/3.6.0/ol.js"></script>
</html>
<body>
    <div>
        <form action=""""),_display_(/*14.24*/action),format.raw/*14.30*/("""" method="post">
            <label>Select a town:</label>
            <input type="text" list=""""),_display_(/*16.39*/name),format.raw/*16.43*/("""" name=""""),_display_(/*16.52*/name),format.raw/*16.56*/("""">
                <datalist id=""""),_display_(/*17.32*/name),format.raw/*17.36*/("""">
                    """),_display_(/*18.22*/towns/*18.27*/.keySet.map/*18.38*/ { item =>_display_(Seq[Any](format.raw/*18.48*/("""
                    """),format.raw/*19.21*/("""<option>"""),_display_(/*19.30*/item),format.raw/*19.34*/("""</option>
                    """)))}),format.raw/*20.22*/("""
                """),format.raw/*21.17*/("""</datalist>
            <button type="submit">send</button>
        </form>
    </div>

    <div """),_display_(/*26.11*/if(town == null)/*26.27*/ {_display_(Seq[Any](format.raw/*26.29*/(""" """),format.raw/*26.30*/("""hidden """)))}),format.raw/*26.38*/(""">"""),_display_(/*26.40*/town),format.raw/*26.44*/("""</div>

    <div """),_display_(/*28.11*/if(town == null)/*28.27*/ {_display_(Seq[Any](format.raw/*28.29*/(""" """),format.raw/*28.30*/("""hidden """)))}),format.raw/*28.38*/(""" """),format.raw/*28.39*/("""style="height:50%;width=100%;overflow:hidden;" >
        <div >
            <div id="map" class="map"></div>
        </div>

        <script>
        var map = new ol.Map("""),format.raw/*34.30*/("""{"""),format.raw/*34.31*/("""
          """),format.raw/*35.11*/("""layers: [
            new ol.layer.Tile("""),format.raw/*36.31*/("""{"""),format.raw/*36.32*/("""
              """),format.raw/*37.15*/("""source: new ol.source.OSM()
            """),format.raw/*38.13*/("""}"""),format.raw/*38.14*/(""")
          ],
          renderer: 'canvas',
          target: 'map',
          view: new ol.View("""),format.raw/*42.29*/("""{"""),format.raw/*42.30*/("""
            """),format.raw/*43.13*/("""center: ol.proj.fromLonLat(["""),_display_(/*43.42*/if(town != null )/*43.59*/ {_display_(Seq[Any](_display_(/*43.62*/town/*43.66*/.xy.y),format.raw/*43.71*/(""","""),_display_(/*43.73*/town/*43.77*/.xy.x)))}),format.raw/*43.83*/("""]),
            zoom: 10
          """),format.raw/*45.11*/("""}"""),format.raw/*45.12*/(""")
        """),format.raw/*46.9*/("""}"""),format.raw/*46.10*/(""");

        // Create the graticule component
        var graticule = new ol.Graticule("""),format.raw/*49.42*/("""{"""),format.raw/*49.43*/("""
          """),format.raw/*50.11*/("""// the style to use for the lines, optional.
          strokeStyle: new ol.style.Stroke("""),format.raw/*51.44*/("""{"""),format.raw/*51.45*/("""
            """),format.raw/*52.13*/("""color: 'rgba(255,120,0,0.9)',
            width: 2,
            lineDash: [0.5, 4]
          """),format.raw/*55.11*/("""}"""),format.raw/*55.12*/(""")
        """),format.raw/*56.9*/("""}"""),format.raw/*56.10*/(""");
        graticule.setMap(map);
        </script>
    </div>

    <div """),_display_(/*61.11*/if(town == null)/*61.27*/ {_display_(Seq[Any](format.raw/*61.29*/(""" """),format.raw/*61.30*/("""hidden """)))}),format.raw/*61.38*/(""" """),format.raw/*61.39*/("""style="height:50%;" >
        <!-- cgi-bin/rssp?customerid=6433&url=http%3A%2F%2Fen -->
        <!-- iframe src=""""),_display_(/*63.27*/if(town != null )/*63.44*/ {_display_(Seq[Any](format.raw/*63.46*/("""http://speechpanel.readspeaker.com/cgi-bin/rssp/212122461053005/start/en/"""),_display_(/*63.120*/town/*63.124*/.link)))}),format.raw/*63.130*/("""" style="width:100%;height:90%;"></iframe -->
        <iframe src=""""),_display_(/*64.23*/if(town != null )/*64.40*/ {_display_(Seq[Any](format.raw/*64.42*/("""http://speechpanel.readspeaker.com/cgi-bin/rssp?customerid=6433&url=http%3A%2F%2Fen."""),_display_(/*64.127*/town/*64.131*/.link)))}),format.raw/*64.137*/("""" style="width:100%;height:90%;"></iframe>
    </div>

</body>
"""))}
  }

  def render(action:java.lang.String,name:java.lang.String,towns:java.util.Map[java.lang.String, de.jwausle.vertx.Server.Data],town:de.jwausle.vertx.Server.Data): play.twirl.api.HtmlFormat.Appendable = apply(action,name,towns,town)

  def f:((java.lang.String,java.lang.String,java.util.Map[java.lang.String, de.jwausle.vertx.Server.Data],de.jwausle.vertx.Server.Data) => play.twirl.api.HtmlFormat.Appendable) = (action,name,towns,town) => apply(action,name,towns,town)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Wed Jan 13 10:19:32 CET 2016
                  SOURCE: /Users/winter/Git/vertx-root/de.jwausle/de.jwausle.vertx.first/src/main/twirl/hello.scala.html
                  HASH: 190598b353ef26af4b2df87500ca154ddb7d4289
                  MATRIX: 578->1|829->165|857->167|1139->422|1166->428|1290->525|1315->529|1351->538|1376->542|1437->576|1462->580|1513->604|1527->609|1547->620|1595->630|1644->651|1680->660|1705->664|1767->695|1812->712|1937->810|1962->826|2002->828|2031->829|2070->837|2099->839|2124->843|2169->861|2194->877|2234->879|2263->880|2302->888|2331->889|2530->1060|2559->1061|2598->1072|2666->1112|2695->1113|2738->1128|2806->1168|2835->1169|2961->1267|2990->1268|3031->1281|3087->1310|3113->1327|3153->1330|3166->1334|3192->1339|3221->1341|3234->1345|3264->1351|3327->1386|3356->1387|3393->1397|3422->1398|3537->1485|3566->1486|3605->1497|3721->1585|3750->1586|3791->1599|3912->1692|3941->1693|3978->1703|4007->1704|4108->1778|4133->1794|4173->1796|4202->1797|4241->1805|4270->1806|4411->1920|4437->1937|4477->1939|4579->2013|4593->2017|4624->2023|4719->2091|4745->2108|4785->2110|4898->2195|4912->2199|4943->2205
                  LINES: 16->1|23->5|25->7|32->14|32->14|34->16|34->16|34->16|34->16|35->17|35->17|36->18|36->18|36->18|36->18|37->19|37->19|37->19|38->20|39->21|44->26|44->26|44->26|44->26|44->26|44->26|44->26|46->28|46->28|46->28|46->28|46->28|46->28|52->34|52->34|53->35|54->36|54->36|55->37|56->38|56->38|60->42|60->42|61->43|61->43|61->43|61->43|61->43|61->43|61->43|61->43|61->43|63->45|63->45|64->46|64->46|67->49|67->49|68->50|69->51|69->51|70->52|73->55|73->55|74->56|74->56|79->61|79->61|79->61|79->61|79->61|79->61|81->63|81->63|81->63|81->63|81->63|81->63|82->64|82->64|82->64|82->64|82->64|82->64
                  -- GENERATED --
              */
          