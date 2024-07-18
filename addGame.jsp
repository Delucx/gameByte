<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <title></title>
    <meta name="description" content="" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link rel="stylesheet" href="/CSS/addGame.css" />
    <style>
        @import url("https://fonts.googleapis.com/css2?family=Kosugi+Maru&family=Press+Start+2P&display=swap");
    </style>
</head>

<body>
    <nav>
        <section>
            <img src="Assets/gameByte_icon.png" alt="gameByteIcon" />
            <h3>gameByte</h3>
        </section>
        <ul>
            <li><a href="/home.html">home</a></li>
            <li><a href="/login.jsp">Hello<img class="profilePic" src="Assets/Profile.png" alt="Profile" /></a></li>
        </ul>
    </nav> 

    <!-- <form action="AddGame" method="post" enctype="multipart/form-data">
        <label for="title">Title:</label><br>
        <input type="text" id="title" name="title" required><br><br>
        
        <label for="creator">Creator:</label><br>
        <input type="text" id="creator" name="creator" required><br><br>
        
        <label for="description">Description:</label><br>
        <textarea id="description" name="description" rows="5" required></textarea><br><br>
        
        <label for="logo">Logo Image:</label><br>
        <input type="file" id="logo" name="logo" accept="image/*" required><br><br>
        
        <label for="background">Background Image:</label><br>
        <input type="file" id="background" name="background" accept="image/*" required><br><br>
        
        <input type="submit" value="Submit">
    </form> -->

    <div class="titleProject">
        <h4>Add New Game</h4>
    </div>

    <form action="" method="" enctype="">
        <div class="column1">
            <div>
                <label for="title">Game Name:</label><br>
                <input type="text" id="title" name="title" class="gameName" required><br><br>
            </div>
        
            <div>
                <label for="creator">Game Developer:</label><br>
                <input type="text" id="creator" name="creator" class="gameDev" required><br><br>
            </div>
            
            <div>
                <label for="description">Game Description:</label><br>
                <textarea id="description" name="description" rows="5" class="gameDesc" required></textarea><br><br>
            </div>
            <div>
                <input type="submit" value="Submit">
            </div>
        </div>

        <div class="column2">
            <label for="logo">Game Logo:</label><br>
            <input type="file" id="logo" name="logo" accept="image/*" class="gameLogo" required><br><br>
            
            <label for="background">Game Banner:</label><br>
            <input type="file" id="background" name="background" accept="image/*" class="gameBanner" required><br><br>
        </div>
    </form>
    
    <script src="" async defer></script>
</body>

</html>