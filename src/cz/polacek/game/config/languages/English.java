package cz.polacek.game.config.languages;

import cz.polacek.game.config.Language;

import java.util.Locale;

public class English extends Language {

    public English() {
        start_game = "You know, it wasn't pleasant last day when the atomic bomb exploded right after you hid. Even thought you didn't had much time to take things with you, something was already in the bunker.";

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
                        "You hear knocking on door loudly. You wonder what that could be and think about opening it. But should you? Radiation maybe didn't still settle down.",
                        "Even thought you wanted so much to open it, you didn't had ball to open it. Oh well, maybe next time.",
                        "You opened the creaking door... And it was local army to come help you and play some cards. And look at that. On their way out the gave you this.",
                        "You opened the creaking door but had no luck. A lot of mutated bugs tried to go through your doors. Luckily you beat those bugs, but unfortunately, lost something."
                },
                {
                        // 2
                        "RADIO_01",
                        "You have been thinking about having some fun... What about radio. You didn't had so much fun with radio since you were young... At least try?",
                        "Well, even thought you wanted to have some fun... you didn't had at all. Well, maybe next time.",
                        "So, last night you've received information about an airdrop near your house. Actually it was right behind your bunker door. How lucky you are?",
                        "Well, this was unexpected. They didn't play your favorite song, so you've got angry and broke some thing in your bunker."
                },
                {
                        // 3
                        "HUNTING_01",
                        "I forgot how many days it was without eating REAL food better than this soup, or if you could call that. You've got and idea, to try hunt something outside! Will you go?",
                        "How sad... You couldn't go hunting. Maybe it is better that way, what could have happen if you go out is just a question.",
                        "Very well, you went outside and actually nothing happened. How lucky! Also, when you have been hunting, you've found some stuff... it is cool... I guess",
                        "You have been a naughty boy today. Actually pretty bad boy. When you opened the bunker door, something flew indoor and made a mess."
                },
                {
                        // 4
                        "KNOCKING_02",
                        "Right before you went to sleep, you hear a knocking on the doors. It is going to make you crazy, it is louder and louder. Do you wish to open it?",
                        "Maybe right idea that you didn't. It also stopped suddenly, what a relief. Wonder what it was.",
                        "Yesterday you opened the doors when a dog came through. It was a your lucky day, because the dog didn't destroy anything, but helped you bring some stuff, when you walked him away!",
                        "How unlucky. An angry dog came to you and tried to steal your food and stuff... You tried to kill the dog down but unfortunately you couldn't defend your stuff and he run away."
                },
                {
                        // 5
                        "SUPPLY_DROP_01",
                        "Do you hear that? It sounded like an airplane, maybe an army tried to drop supplies to your local town. Would you like to try and take some stuff? Maybe it isn't a supply drop at all!",
                        "Yes, right decision! Stay at your bunker at all costs, it is damn good to sit down and wait till somebody come help us. Or is it? Don't think about it, it is good that we are safe for now.",
                        "No way! You have found an extra supplies in the supply drop. You have been lucky for today and have taken the supplies that you could carry!",
                        "Even though it was a real supply drop, nothing was there. Stupid people stole everything... they even stole some of your stuff while you were gone!"
                },
                {
                        // 6
                        "ARMY_CALLOUTS_01",
                        "You hear sirens calling different names. One of those names way yours... Do you want to go out and see what is going on or stay in a bunker like coward?",
                        "You coward!",
                        "You came outside and in the middle of your town there was an army with supplies. They were giving away some stuff to people they were naming.",
                        "You came outside and in the middle of your town there was an bandits with guns. They demanded your stuff in exchange to not killing you. You gave them what they wanted!"
                }
        };

        event_fix_text = new String[][] {
            {
                "FIX_EVENT_01",
                "It is fixing time! At least, if you have your handy tape to fix things. Well, let's have some fun and fix things! Yeah, that would be fun!",
                "Oh no! Why you didn't try. It is way more fun than sitting it this room and waiting for the rescue...",
                "Nicely done! You should call yourself a fixing mister. You've fixed it!",
                "How unlucky, it is sad that you couldn't fix it... Oh well. Maybe next time!"
            }
        };

        day = "Day ";
        gain = "GAIN:";
        lose = "LOSE:";
    }

}
