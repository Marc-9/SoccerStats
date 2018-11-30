# SoccerStats Info

<p>Soccer Stats is a Java Based program that allows the user to calculate any type of stats/data that they wish.</p>
<p>Users may download their own data of any type and load it into the program and run a couple of pre-defined functions on them or make their own.</p>
<p>Soccer Stats is still in its beginning so few commands exists and there is no GUI yet, additionally while Java is not the best language for data analytics it is very beginner friendly.</p>
<h1>Files and Functions</h1>
<p>Currently the program only contains two files, but they can be used for multiple different leagues</p>
<h3>Games.java</h3>
<p>The Games.java file has a Constructor Games that can take in different types of data, you can change this to fit whatever stats you have.</p>
<p>I overwrote the tostring method to print out the result of a game, this is only because my data was formatted to show individual games in the season, this can be changed once again to fit your data needs </p>
<p>InInterval and create date are to be finished methods, where I hope to be able to show games from a certain date range. This has multiple uses including building tables from past weeks, or viewing how a team does over winter. </p>
<h3>Season.java</h3>
<p>The second file is Season.java that creates and ArrayList of Games from the Games.java file</p>
<p>I then created a addGame and readGame function which can be applied to user defined inputs</p>
<p>Proccessline was made just for reading sake as is a part of ReadGame</p>
<p>To string is another again just made for the data I input, and it calls the toString method made in Games.java</p>
<p>Lastly findGames.java is a work in process as would call and find games from the inInterval function</p>
<h1> Commands </h1>
<p>Now that you understand each file and their function lets learn how to implement these to run analytics on your data, this code goes into the Main Body of Season.java</p>
<h2>Initalize Data</h2>
<ol>
  <li>Season SEASON_NAME = new Season();</li>
    <ul>
      <li>Creates an instance of Season, to run commands in Season with</li>
    </ul>
  <li>SEASON_NAME.readGames(“[File Name]“);</li>
    <ul>
      <li>Reads the stats from the file into the provided data constructors, the Stats have now been initialized and you can use the methods provided to run analysis or create your own. Below are some examples</li>
    </ul>
 </ol>
 <p></p>
<h1>To do</h1>
<ol>
  <li>Finish InInterval... and other functions relating to dates</li>
  <li>Add functions to automaticaly grab goals scored and other stats.</li>
  <li>Add more stats and leagues </li>
  <li>Make my own compare to function</li>
  <li>Add stats for players</li>
  <li>GUI</li>
