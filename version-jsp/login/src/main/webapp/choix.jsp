<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link
      href="https://api.fontshare.com/v2/css?f[]=switzer@700,400&f[]=gambarino@400&display=swap"
      rel="stylesheet"
    />
    <style>
      * {
        padding: 0%;
        margin: 0%;
        box-sizing: border-box;
      }
      body {
        background-color: #f5f5f5;
        font-family: "Switzer", sans-serif;
        color : white;
      }

      a,
      a:hover,
      a:focus,
      a:active {
        text-decoration: none;
        color: inherit;
      }

      #container {
        display: flex;
        justify-content: center;
        align-items: center;
        margin: 20rem;
        gap: 2rem;
      }

      button {
        background-color: transparent;
        color: black;
        padding: 1rem;
        border: 1px solid black;
        font-size: 18px;
        border-radius: 1rem;
      }

      button:hover {
        background-color: rgb(49, 49, 49);
        color: rgb(230, 230, 230);
        padding: 1rem;
        border: none;
        font-size: 18px;
        border-radius: 1rem;
      }

      .container {
        display: flex;
      }

      .left_section,
      .left_section:hover {
        display: flex;
        justify-content: center;
        align-items: center;
        width: 50%;
        height: 100vh;
      }
      .right_section,
      .right_section:hover {
        display: flex;
        justify-content: center;
        align-items: center;
        width: 50%;
        height: 100vh;
      }

      .right_section:hover,
      .left_section:hover {
        background-color: rgb(206, 206, 206);
      }
    </style>
    <title>Choice</title>
  </head>
<body>
	<div class="container-login100" style="background-image: url('images/bg-01.jpg');">
    <div class="container">
      <div class="left_section">
        <a href="loginadmin.jsp"><h1>ADMIN</h1></a>
      </div>
      <div class="right_section">
        <a href="loginteacher.jsp"><h1>TEACHER</h1></a>
      </div>
    </div>
    </div>
  </body>
</html>