<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <title></title>
    <meta name="description" content="" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link rel="stylesheet" href="/CSS/gp.css" />
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
            <li><a href="#">community</a></li>
            <li><a href="/login.jsp">Hello<img class="profilePic" src="Assets/Profile.png" alt="Profile" /></a></li>
        </ul>
    </nav>

    <header>
        <section>
            <div class="stardewBG">
                <div class="imgCont">
                    <img src="Assets/stardewValley.png" alt="Stardew Valley" title="Stardew Valley" />
                </div>
                <div class="container">
                    <div class="genre">
                        <p>Farming Sim</p>
                        <p>Multiplayer</p>
                    </div>
                    <h1>Stardew Valley</h1>
                    <h4>ConcernedApe</h4>
                </div>
            </div>
        </section>
    </header>

    <div class="contentContainer">
        <div class="leftSide">
            <div class="infoGame">
                <div class="title">
                    <h4>About this Game</h4>
                </div>
                <section>
                    <p>
                        You've inherited your grandfather's old farm plot in Stardew Valley.
                        Armed with hand-me-down tools and a few coins, you set out to begin
                        your new life. Can you learn to live off the land and turn these
                        overgrown fields into a thriving home? It won't be easy. Ever since
                        Joja Corporation came to town, the old ways of life have all but
                        disappeared. The community center, once the town's most vibrant hub
                        of activity, now lies in shambles. But the valley seems full of
                        opportunity. With a little dedication, you might just be the one to
                        restore Stardew Valley to greatness!
                    </p>
                </section>
            </div>
    
            <div class="systemRequirements">
                <div class="title">
                    <h4>System Requirements</h4>
                </div>
                <section>
                    <p>OS *: Windows Vista or greater</p>
                    <p>Processor: 2 Ghz</p>
                    <p>Memory: 2 GB RAM</p>
                    <p>Graphics: 256 mb video memory, shader model 3.0+</p>
                    <p>DirectX: Version 10</p>
                    <p>Storage: 500 MB available space</p>
                </section>
            </div>
        </div>
    
        <div class="rightSide">
            <div class="commentReview">
                <div class="profileImg">
                    <img src="Assets/Profile.png" alt="Profile" />
                </div>
                <form action="" method="">
                    <input type="hidden" name="userName" value="<%= loggedInUser %>" />
                    <h6>Write a Review for Game</h6>
                    <p>
                        Please describe what you liked or disliked about this game and
                        whether you recommend it to others.
                    </p>
                    <div class="inputBox">
                        <textarea name="comment" id="comment" cols="40" rows="10">Write a Review...</textarea>
                    </div>
                    <div class="recommendCont">
                        <p>Do you recommend this game?</p>
                        <div class="radio">
                            <input type="radio" id="yes" name="recommend" value="yes" />
                            <label for="yes" class="thumbsUp"><svg xmlns="http://www.w3.org/2000/svg" class="bi bi-hand-thumbs-up-fill colorUp" viewBox="0 0 16 16">
                                <path d="M6.956 1.745C7.021.81 7.908.087 8.864.325l.261.066c.463.116.874.456 1.012.965.22.816.533 2.511.062 4.51a10 10 0 0 1 .443-.051c.713-.065 1.669-.072 2.516.21.518.173.994.681 1.2 1.273.184.532.16 1.162-.234 1.733q.086.18.138.363c.077.27.113.567.113.856s-.036.586-.113.856c-.039.135-.09.273-.16.404.169.387.107.819-.003 1.148a3.2 3.2 0 0 1-.488.901c.054.152.076.312.076.465 0 .305-.089.625-.253.912C13.1 15.522 12.437 16 11.5 16H8c-.605 0-1.07-.081-1.466-.218a4.8 4.8 0 0 1-.97-.484l-.048-.03c-.504-.307-.999-.609-2.068-.722C2.682 14.464 2 13.846 2 13V9c0-.85.685-1.432 1.357-1.615.849-.232 1.574-.787 2.132-1.41.56-.627.914-1.28 1.039-1.639.199-.575.356-1.539.428-2.59z"/>
                              </svg></label>
                        </div>
                        <div class="radio">
                            <input type="radio" id="no" name="recommend" value="no" />
                            <label for="no" class="thumbsDown"><svg xmlns="http://www.w3.org/2000/svg" class="bi bi-hand-thumbs-down-fill colorDown" viewBox="0 0 16 16">
                                <path d="M6.956 14.534c.065.936.952 1.659 1.908 1.42l.261-.065a1.38 1.38 0 0 0 1.012-.965c.22-.816.533-2.512.062-4.51q.205.03.443.051c.713.065 1.669.071 2.516-.211.518-.173.994-.68 1.2-1.272a1.9 1.9 0 0 0-.234-1.734c.058-.118.103-.242.138-.362.077-.27.113-.568.113-.856 0-.29-.036-.586-.113-.857a2 2 0 0 0-.16-.403c.169-.387.107-.82-.003-1.149a3.2 3.2 0 0 0-.488-.9c.054-.153.076-.313.076-.465a1.86 1.86 0 0 0-.253-.912C13.1.757 12.437.28 11.5.28H8c-.605 0-1.07.08-1.466.217a4.8 4.8 0 0 0-.97.485l-.048.029c-.504.308-.999.61-2.068.723C2.682 1.815 2 2.434 2 3.279v4c0 .851.685 1.433 1.357 1.616.849.232 1.574.787 2.132 1.41.56.626.914 1.28 1.039 1.638.199.575.356 1.54.428 2.591"/>
                              </svg></label>
                        </div>
                    </div>
                    <div class="submitBtn">
                        <button type="submit">Post Review</button>
                    </div>
                </form>
            </div>
    
            <div class="postedReview">
                <div>
                    <h4>Reviews</h4>
                </div>
                <section>
                    <div class="commentPost">
                        <div class="recommendProfile">
                            <img src="Assets/Profile.png" alt="Profile" />
                            <img src="Assets/steamIcon.png" alt="SteamIcon" />
                        </div>
                        <div class="userComment">
                            <h6>Username</h6>
                            <p>
                                Lorem ipsum
                            </p>
                        </div>
                    </div>
                    <div class="commentPost">
                        <div class="recommendProfile">
                            <img src="Assets/Profile.png" alt="Profile" />
                            <img src="Assets/steamIcon.png" alt="SteamIcon" />
                        </div>
                        <div class="userComment">
                            <h6>Username</h6>
                            <p>
                                Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed
                                malesuada, nunc nec lacinia.
                            </p>
                        </div>
                    </div>
                </section>
            </div>
        </div>
    </div>
    

    <div><br /><br /><br /><br /><br /><br /><br /><br /><br /></div>

    <script src="" async defer></script>
</body>

</html>