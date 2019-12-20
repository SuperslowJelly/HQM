package hqm.client.gui.page;

import hqm.HQM;
import hqm.client.Colors;
import hqm.client.gui.GuiQuestBook;
import hqm.client.gui.IPage;
import hqm.client.gui.component.ComponentPageOpenButton;
import hqm.client.gui.component.ComponentSingleText;
import hqm.client.gui.component.ComponentTextArea;
import hqm.quest.Questbook;
import hqm.quest.Team;
import net.minecraft.util.ResourceLocation;

import java.util.ArrayList;
import java.util.List;

/**
 * @author canitzp
 */
public class InformationPage implements IPage {

    @Override
    public void init(GuiQuestBook gui) {
        Questbook questbook = gui.getQuestbook();
        List<ComponentSingleText> questbookText = new ArrayList<>();
        questbookText.add(new ComponentSingleText("Quests", Side.LEFT).setColor(0x282828).setScale(1.25F));
        questbookText.add(new ComponentSingleText(String.format("%d questlines with", questbook.countQuestLines()), Side.LEFT).setScale(0.9F).setHoveringText(questbook.getQuestLineNames()));
        questbookText.add(new ComponentSingleText(String.format("%d quests in total", questbook.countQuests()), Side.LEFT).setColor(0x282828).setScale(0.9F));
        questbookText.add(new ComponentSingleText(String.format("%d unlocked quests", questbook.countUnlockedQuests(gui.getTeam())), Side.LEFT).setColor(0x4caece).setScale(0.9F));
        questbookText.add(new ComponentSingleText(String.format("%d completed quests", questbook.countCompletedQuests(gui.getTeam())), Side.LEFT).setColor(0x35a051).setScale(0.9F));
        questbookText.add(new ComponentSingleText(String.format("%d available for completion", questbook.countUnlockedUncompleteQuests(gui.getTeam())), Side.LEFT).setColor(0x395aa8).setScale(0.9F));
        gui.addRenderer(new ComponentTextArea(questbookText, Side.LEFT));
        gui.addRenderer(new ComponentPageOpenButton(50, 65, new QuestLinePage(), Side.LEFT).setText(new ComponentSingleText("Click here to show quests", Side.LEFT).setScale(0.75F).setColor(Colors.LIGHT_GRAY)));

        Team team = gui.getTeam();
        List<ComponentSingleText> teamText = new ArrayList<>();
        teamText.add(new ComponentSingleText("Team", Side.RIGHT).setScale(1.25F));
        teamText.add(new ComponentSingleText(String.format("Name:  %s", team.name), Side.RIGHT).setScale(0.9F));
        teamText.add(new ComponentSingleText(String.format("Color: %d", team.color), Side.RIGHT).setScale(0.9F));
        teamText.add(new ComponentSingleText("", Side.RIGHT).setScale(0.5F));
        teamText.add(new ComponentSingleText(String.format("Lives: %d", team.lives), Side.RIGHT).setScale(0.9F));
        gui.addRenderer(new ComponentTextArea(teamText, Side.RIGHT));
        gui.addRenderer(new ComponentPageOpenButton(GuiQuestBook.PAGE_WIDTH / 2, 66, new TeamPage(), Side.RIGHT).setText(new ComponentSingleText("Team Settings [WIP]", Side.RIGHT)));
    }

    @Override
    public ResourceLocation getId() {
        return new ResourceLocation(HQM.MODID, "information_page");
    }

    @Override
    public void render(GuiQuestBook gui, int pageLeft, int pageTop, double mouseX, double mouseY, Side side) {

    }
}