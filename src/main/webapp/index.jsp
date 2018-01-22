<html>
    <head>
        <title>LOGIN</title>
        <style>
         .login{
             position: fixed;
             top: 50%;
             left: 50%;
             margin-top: -150px;
             margin-left: -160px;
             }
             p{
                 padding-top: 40px;
               margin-top: 10px;
             }
            </style>
    </head>
    <body style="background-color: rgb(117, 151, 247) ">
            <center><p><font face="Comic Sans MS" color="white"><pre><h1>  LOGIN</h1></pre></font></h1></p></center>
            <form  class="login" method="post" action="validation">
            <table align="center" cellpadding = "10">
       <tr><td> Email ID:</td><td><input type="text" name="email" /></td><br/></tr>
      <tr> <td> Password: </td><td><input type="password" name="pass" /></td><br/></tr>
      <tr> <td></td> <td><pre><Button type="submit" >Sign in</Button>        <Button type="submit" formaction="regis.html">Sign up</Button></pre></td></tr>
            </table> </form>
    </body>
</html>