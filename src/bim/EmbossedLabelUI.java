package bim;

/**
 *
 * @author Hanynowsky <hanynowsky@gmail.com>
 */
import java.awt.*;
import javax.swing.JLabel;
import javax.swing.plaf.basic.BasicGraphicsUtils;
import javax.swing.plaf.basic.BasicLabelUI;

/**
 *
 * @author XR1CTSO A simple UI implementation that renders an embossed text.
 * Only enabled text is implemented as of now.
 */
public class EmbossedLabelUI extends BasicLabelUI {

    static {
        labelUI = new EmbossedLabelUI();
    }

    @Override
    protected void paintEnabledText(JLabel l, Graphics g, String s, int textX,
            int textY) {
        Graphics2D g2 = (Graphics2D) g.create();

        g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
        g2.setColor(Color.WHITE);
        BasicGraphicsUtils.drawString(g2, s, 0, textX, textY + 1);
        g2.setColor(SwingRConstants.EMBOSS_FOREGROUND_COLOR);
        BasicGraphicsUtils.drawString(g2, s, 0, textX, textY);
        g2.dispose();
    }
}

class SwingRConstants {

    public static final Color ALTERNATE_ROW_COLOR = new Color(0xEDF3FE);
    public static final Color PANEL_DEEP_BACKGROUND_COLOR = new Color(0xCBD1DC);
    public static final Color EMBOSS_FOREGROUND_COLOR = new Color(0x444444);
    public static final Color PANEL_GRADIENT_START_COLOR = new Color(0xC5C5C4);
    public static final Color PANEL_GRADIENT_END_COLOR = new Color(0x979596);
    public static final Font DEFAULT_HEADER_FONT = new Font("Sans-Serif", Font.BOLD, 11);
    public static final Font DEFAULT_TEXT_FONT = new Font("Sans-Serif", Font.PLAIN, 11);
    public static final Color DEFAULT_SELECTION_BACKGROUND_COLOR = new Color(0x3D80DF);
}