<html>
 <head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <script type="text/javascript">
   function disable(buttonid){
    var button1_name;
    var button2_name;
    if(buttonid=="button1"){
     button1_name=document.getElementById('button1').name;
     button1_name++;
     document.getElementById('button1').name=button1_name;
     alert("Click Button 1 :: "+document.getElementById('button1').name)
    }else{
     button2_name=document.getElementById('button2').name;
     button2_name++;
     document.getElementById('button2').name=button2_name;
     alert("Click Button 2 :: "+document.getElementById('button2').name)
    }
   if(button1_name==3){
     document.getElementById('button1').disabled = true;
     document.getElementById('button2').disabled = false;
     document.getElementById('button1').name=0;
    }
   if(button2_name==3){
     document.getElementById('button2').disabled = true;
     document.getElementById('button1').disabled = false;
     document.getElementById('button2').name=0;
    }
  }
 </script>
 </meta>
</head>
<body>
 <table align="center" >
  <tr>
   <td><input type="button" id="button1" name="0" 
       value="Button 1" onclick="disable(this.id)" /></td>
  </tr>
  <tr>
   <td><input type="button"  id="button2"  name="0" disabled
     value="Button 2" onclick="disable(this.id)" /></td>
  </tr>
 </table>
</body>
</html>

