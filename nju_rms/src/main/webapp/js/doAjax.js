 function doAjax(url1, data1, func){
	    	
	        jQuery.ajax({type:"GET", url:url1,data:data1, dataType:"json", jsonp:"callback", success:func
	    , error:function(){
	        alert("Ajax Error.");
	    	}
				})
			}