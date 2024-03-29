/**
 * 
 */

/*! maphilight 26-05-2019 */

!function(t,i)
{
	"function"==typeof define&&define
	.amd?define(["jquery"],i):i(t.jQuery)
}

(this,function(d)
		{
			var c,f,p,u,g,m,v,e,l,w,y;
			if(f=!!document.createElement("canvas").getContext,c=function()
					{
						var t=document.createElement("div");
						t.innerHTML='<v:shape id="vml_flag1" adj="1" />';
						var i=t.firstChild;
						return i.style.behavior="url(#default#VML)",!i||"object"==typeof i.adj}(),f||c)
						{
							if(f){e=function(t){return Math.max(0,Math.min(parseInt(t,16),255))},l=function(t,i)
								{return "rgba("+e(t.substr(0,2))+","+e(t.substr(2,2))+","+e(t.substr(4,2))+","+i+")"},p=function(t)
								{
									var i=d('<canvas style="width:'+d(t).width()+"px;height:"+d(t).height()+'px;"></canvas>').get(0);
									return i.getContext("2d").clearRect(0,0,d(t).width(),d(t).height()),i};
									function b(t,e,a,o,r)
									{
										if(o=o||0,r=r||0,t.beginPath(),"rect"==e)t.rect(a[0]+o,a[1]+r,a[2]-a[0],a[3]-a[1]);
										else if("poly"==e)for(t.moveTo(a[0]+o,a[1]+r),i=2;i<a.length;i+=2)t.lineTo(a[i]+o,a[i+1]+r);
										else"circ"==e&&t.arc(a[0]+o,a[1]+r,a[2],0,2*Math.PI,!1);
										t.closePath()}u=function(t,i,e,a,o)
										{
											var r=t.getContext("2d");if(a.shadow){r.save(),"inside"==a.shadowPosition&&(b(r,i,e),r.clip());
											var s=100*t.width,n=100*t.height;b(r,i,e,s,n),r.shadowOffsetX=a.shadowX-s,r.shadowOffsetY=a.shadowY-n,r.shadowBlur=a.shadowRadius,r.shadowColor=l(a.shadowColor,a.shadowOpacity);
											var h=a.shadowFrom;
											h||(h="outside"==a.shadowPosition?"fill":"stroke"),"stroke"==h?(r.strokeStyle="rgba(0,0,0,1)",r.stroke()):"fill"==h&&(r.fillStyle="rgba(0,0,0,1)",r.fill()),r.restore(),"outside"==a.shadowPosition&&(r.save(),b(r,i,e),r.globalCompositeOperation="destination-out",r.fillStyle="rgba(0,0,0,1);",r.fill(),r.restore())}r.save(),b(r,i,e),a.fill&&(r.fillStyle=l(a.fillColor,a.fillOpacity),r.fill()),a.stroke&&(r.strokeStyle=l(a.strokeColor,a.strokeOpacity),r.lineWidth=a.strokeWidth,r.stroke()),r.restore(),a.fade&&d(t).css("opacity",0).animate({opacity:1},100)},g=function(t){t.getContext("2d").clearRect(0,0,t.width,t.height)}}else p=function(t){return d('<var style="zoom:1;overflow:hidden;display:inline-block;width:'+t.width+"px;height:"+t.height+'px;"></var>').get(0)},u=function(t,i,e,a,o){var r,s,n,h;for(var l in e)e[l]=parseInt(e[l],10);r='<v:fill color="#'+a.fillColor+'" opacity="'+(a.fill?a.fillOpacity:0)+'" />',s=a.stroke?'strokeweight="'+a.strokeWidth+'" stroked="t" strokecolor="#'+a.strokeColor+'"':'stroked="f"',n='<v:stroke opacity="'+a.strokeOpacity+'"/>',"rect"==i?h=d('<v:rect name="'+o+'" filled="t" '+s+' style="zoom:1;margin:0;padding:0;display:inline-block;position:absolute;left:'+e[0]+"px;top:"+e[1]+"px;width:"+(e[2]-e[0])+"px;height:"+(e[3]-e[1])+'px;"></v:rect>'):"poly"==i?h=d('<v:shape name="'+o+'" filled="t" '+s+' coordorigin="0,0" coordsize="'+t.width+","+t.height+'" path="m '+e[0]+","+e[1]+" l "+e.join(",")+' x e" style="zoom:1;margin:0;padding:0;display:inline-block;position:absolute;top:0px;left:0px;width:'+t.width+"px;height:"+t.height+'px;"></v:shape>'):"circ"==i&&(h=d('<v:oval name="'+o+'" filled="t" '+s+' style="zoom:1;margin:0;padding:0;display:inline-block;position:absolute;left:'+(e[0]-e[2])+"px;top:"+(e[1]-e[2])+"px;width:"+2*e[2]+"px;height:"+2*e[2]+'px;"></v:oval>')),h.get(0).innerHTML=r+n,d(t).append(h)},g=function(t){var i=d("<div>"+t.innerHTML+"</div>");i.children("[name=highlighted]").remove(),t.innerHTML=i.html()};m=function(t){var i,e,a=(t.getAttribute("shape")||"rect").toLowerCase().substr(0,4);if("defa"!==a){for(e=(t.getAttribute("coords")||"").split(","),i=0;i<e.length;i++)e[i]=parseFloat(e[i]);return[a,e]}},y=function(t,i){var e=d(t);return d.extend({},i,!!d.metadata&&e.metadata(),e.data("maphilight"))},w=function(t){return!!t.complete&&(void 0===t.naturalWidth||0!==t.naturalWidth)};var t=!(v={position:"absolute",left:0,top:0,padding:0,border:0});d.fn.maphilight=function(l){return l=d.extend({},d.fn.maphilight.defaults,l),f||t||(d(window).ready(function(){document.namespaces.add("v","urn:schemas-microsoft-com:vml");var t=document.createStyleSheet();d.each(["shape","rect","oval","circ","fill","stroke","imagedata","group","textbox"],function(){t.addRule("v\\:"+this,"behavior: url(#default#VML); antialias:true")})}),t=!0),this.each(function(){var e,t,s,n,h,a,i,o;if(e=d(this),!w(this))return window.setTimeout(function(){e.maphilight(l)},200);if(s=d.extend({},l,!!d.metadata&&e.metadata(),e.data("maphilight")),(i=e.get(0).getAttribute("usemap"))&&(n=d('map[name="'+i.substr(1)+'"]'),e.is('img,input[type="image"]')&&i&&0<n.length)){if(e.hasClass("maphilighted")){var r=e.parent();e.insertBefore(r),r.remove(),d(n).unbind(".maphilight")}o=this.src.replace(/[\n\r]/g,""),t=d("<div></div>").css({display:"inline-block",backgroundImage:'url("'+o+'")',backgroundSize:"contain",position:"relative",padding:0,width:this.width,height:this.height}),s.wrapClass&&(!0===s.wrapClass?t.addClass(d(this).attr("class")):t.addClass(s.wrapClass)),e.before(t).css("opacity",1e-10).css(v).remove(),c&&e.css("filter","Alpha(opacity=0)"),t.append(e),h=p(this),d(h).css(v),h.height=this.height,h.width=this.width,d(n).bind("alwaysOn.maphilight",function(){a&&g(a),f||d(h).empty(),d(n).find("area[coords]").each(function(){var t,i;if((i=y(this,s)).alwaysOn){if(!a&&f&&(a=p(e[0]),d(a).css(v),a.width=e[0].width,a.height=e[0].height,e.before(a)),i.fade=i.alwaysOnFade,!(t=m(this)))return;u(f?a:h,t[0],t[1],i,"")}})}).trigger("alwaysOn.maphilight").bind("mouseover.maphilight focusin.maphilight",function(t){var i,e,a=t.target;if(!(e=y(a,s)).neverOn&&!e.alwaysOn){if(!(i=m(a)))return;if(u(h,i[0],i[1],e,"highlighted"),e.groupBy){var o;o=/^[a-zA-Z][\-a-zA-Z]+$/.test(e.groupBy)?n.find("area["+e.groupBy+'="'+d(a).attr(e.groupBy)+'"]'):n.find(e.groupBy);var r=a;o.each(function(){if(this!=r){var t=y(this,s);if(!t.neverOn&&!t.alwaysOn){var i=m(this);u(h,i[0],i[1],t,"highlighted")}}})}f||d(h).append("<v:rect></v:rect>")}}).bind("mouseout.maphilight focusout.maphilight",function(t){g(h)}),e.before(h),e.addClass("maphilighted")}})},d.fn.maphilight.defaults={fill:!0,fillColor:"000000",fillOpacity:.2,stroke:!0,strokeColor:"ff0000",strokeOpacity:1,strokeWidth:1,fade:!0,alwaysOn:!1,neverOn:!1,groupBy:!1,wrapClass:!0,shadow:!1,shadowX:0,shadowY:0,shadowRadius:6,shadowColor:"000000",shadowOpacity:.8,shadowPosition:"outside",shadowFrom:!1}}else d.fn.maphilight=function(){return this}});