import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import javax.security.auth.login.LoginException;

public class Main extends ListenerAdapter {

    public static JDABuilder jdaBuilder;

    public static void main(String[] args) throws LoginException {

        jdaBuilder = JDABuilder.createDefault( "(PASTE UR BOT TOKEN HERE)" );
        jdaBuilder.setActivity( Activity.listening( "Ur Wish" ) );
        jdaBuilder.setStatus( OnlineStatus.ONLINE );
        jdaBuilder.addEventListeners( new Main() );
        jdaBuilder.build();
    }

    @Override
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event) {
        String message = event.getMessage().getContentRaw();

        switch (message){
            case "$help":
                event.getChannel().sendMessage( "Put Ur Text" ).queue();
                break;
            case "$hi":
                event.getChannel().sendMessage( "Hello!" ).queue();
                break;
        }
    }
}
