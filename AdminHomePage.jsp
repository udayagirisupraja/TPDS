
<!DOCTYPE html >
<html>
<head>
<style>
ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
    overflow: hidden;
    background-color: #333;
}

li {
    float: left;
}
li a {
    display: block;
    color: white;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
}

li a:hover{
    background-color: green;
}
 .modal-header, h4, .close {
      background-color: #5cb85c;
      color:white !important;
      text-align: center;
      font-size: 30px;
  }
  .modal-footer {
      background-color: #f9f9f9;
  }

 </style>
</head>
<body background="24.jpg">


<ul>
  <li><a class="active" id="myBtn1">addDistricts</a></li>
  <li><a href="FrontController?action=viewDistricts">viewDistricts</a></li>
  <li><a class="active" id="myBtn">addWards</a></li>
  <li><a href="FrontController?action=viewWards">viewWards</a></li>
  <li><a href="FrontController?action=AdminGoodsDisplay">goods</a></li> 
  <li style ="float:right"><a href = "tpds.html" class="active" id="myBtn">Logout</a></li>
</ul>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <!-- Modal -->
  <div class="modal" id="myModal">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <h4 class="modal-title">addWard</h4>
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
        <div class="modal-body">
                <form action = "FrontController" method = "post">
               <input type = "hidden" name = "action" value = "addWards">
                DistrictId:<br>
                     <input type = "text" name = "dstid"></br></br>
                WardName:<br> 
                     <input type = "text" name = "wname"></br></br>
                WardId:<br>
                     <input type = "text" name = "wid"></br></br>
      

             	<button type="submit" class="btn btn-primary">Submit</button>
             	</form>
       </div>
</div>
       <div class="modal-footer">
          <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
      </div>
   </div>
</div>

       <!-- Modal -->

  <div class="modal fade" id="myModal1" role ="dialog" ">
    <div class="modal-dialog">
      <div class="modal-content">
      
        <!-- Modal Header -->
        <div class="modal-header">
          <h4 class="modal-title">addDistrict</h4>
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
        
        <!-- Modal body -->
        <div class="modal-body">
				 <form action = "FrontController" method = "post">
               		<input type = "hidden" name = "action" value = "addDistricts">
                
                DistrictName:<br>
                     <input type = "text" name = "dname"></br></br>
                DistrictId:<br> 
                     <input type = "text" name = "did"></br></br>

                    <button type="submit" class="btn btn-primary">Submit</button>
                    </form>
</div>
</div> 
        
        <!-- Modal footer -->
        <div class="modal-footer">
          <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
        </div>
        
      </div>
</div>
<script>

$(document).ready(function(){
	    $("#myBtn").click(function(){
	        $("#myModal").modal();
	    });
	    $("#myBtn1").click(function(){
	        $("#myModal1").modal();
	    });
	});
</script>

</body>
</head>
</html>