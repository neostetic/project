package cz.polacek.game.config.languages;

import cz.polacek.game.config.Language;

public class English extends Language {

    public English() {
        start_game = "You know, it wasn't pleasant last day when the atomic bomb exploded right after you hid. Even thought you didn't had much time to take things with you, something was already in the bunker. Anyways, it is your first day in this new home, so you don't need to do anything today. Sleep well my friend!<br><br>" +
                "YOU GAIN:<br>";

        event_text = new String[][]{
                {
                        "0_EVENT_NAME",
                        "1_TEXT_INFORMATION",
                        "2_TEXT_DECLINE",
                        "3_TEXT_ACCEPT_POSITIVE",
                        "4_TEXT_ACCEPT_NEGATIVE"
                },
                {
                        // 1
                        "KNOCKING_01",
                        "You hear knocking on door loudly. You wonder what that could be and think about opening it. But should you? Radiation maybe didn't still settle down.<br><br>",
                        "Even thought you wanted so much to open it, you didn't had ball to open it. Oh well, maybe next time.<br><br>",
                        "You opened the creaking door... And it was local army to come help you and play some cards. And look at that. On their way out the gave you this.<br><br>" +
                                "YOU GAIN:<br>",
                        "You opened the creaking door but had no luck. A lot of mutated bugs tried to go through your doors. Luckily you beat those bugs, but unfortunately, lost something.<br>" +
                                "YOU LOST:<br>"
                },
                {
                        // 2
                        "RADIO_01",
                        "You have been thinking about having some fun... What about radio. You didn't had so much fun with radio since you were young... At least try?<br><br>",
                        "Well, even thought you wanted to have some fun... you didn't had at all. Well, maybe next time.<br><br>",
                        "So, last night you've received information about an airdrop near your house. Actually it was right behind your bunker door. How lucky you are?<br>" +
                                "YOU GAIN:<br>",
                        "Well, this was unexpected. They didn't play your favorite song, so you've got angry and broke some thing in your bunker.<br>" +
                                "YOU LOST:<br>"
                },
                {
                        // 3
                        "HUNTING_01",
                        "I forgot how many days it was without eating REAL food better than this soup, or if you could call that. You've got and idea, to try hunt something outside! Will you go?<br><br>",
                        "How sad... You couldn't go hunting. Maybe it is better that way, what could have happen if you go out is just a question.<br><br>",
                        "Very well, you went outside and actually nothing happened. How lucky! Also, when you have been hunting, you've found some stuff... it is cool... I guess" +
                                "YOU GAIN:<br>",
                        "You have been a naughty boy today. Actually pretty bad boy. When you opened the bunker door, something flew indoor and made a mess.<br>" +
                                "YOU LOST:<br>"
                }
        };

        days = "<b>Day " + config.game_daycount + "</b><br><br>";
    }

}
