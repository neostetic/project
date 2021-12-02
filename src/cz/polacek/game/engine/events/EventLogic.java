package cz.polacek.game.engine.events;

public class EventLogic {

    public final String[][] event_text = {
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
                "You here knocking on door loudly. You wonder what that could be and think about opening it. But should you? Radiation maybe didn't still settle down.\n\n",
                "Even thought you wanted so much to open it, you didn't had ball to open it. Oh well, maybe next time.\n\n",
                "You opened the creaking door... And it was local army to come help you and play some cards. And look at that. On their way out the gave you this.\n\n" +
                        "YOU GAIN:\n",
                "You opened the creaking door but had no luck. A lot of mutated bugs tried to go through your doors. Luckily you beat those bugs, but unfortunately, lost something.\n" +
                        "YOU LOST:\n"
            },
            {
                // 2
                "RADIO_01",
                "You have been thinking about having some fun... What about radio. You didn't had so much fun with radio since you were young... At least try?\n\n",
                "Well, even thought you wanted to have some fun... you didn't had at all. Well, maybe next time.\n\n",
                "So, last night you've received information about an airdrop near your house. Actually it was right behind your bunker door. How lucky you are?\n" +
                        "YOU GAIN:\n",
                "Well, this was unexpected. They didn't play your favorite song, so you've got angry and broke some thing in your bunker.\n" +
                        "YOU LOST:\n"
            },
            {
                // 3
                "HUNTING_01",
                "I forgot how many days it was without eating REAL food better than this soup, or if you could call that. You've got and idea, to try hunt something outside! Will you go?\n\n",
                "How sad... You couldn't go hunting. Maybe it is better that way, what could have happen if you go out is just a question.\n\n",
                "Very well, you went outside and actually nothing happened. How lucky! Also, when you have been hunting, you've found some stuff... it is cool... I guess" +
                        "YOU GAIN:\n",
                "You have been a naughty boy today. Actually pretty bad boy. When you opened the bunker door, something flew indoor and made a mess.\n" +
                        "YOU LOST:\n"
            }
    };

    public String[][] special_event_text;
    public String[][] sickness;

}
