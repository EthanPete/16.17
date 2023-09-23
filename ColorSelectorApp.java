import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class ColorSelectorApp {
    private JFrame frame;
    private JPanel colorPanel;
    private JSlider redSlider;
    private JSlider greenSlider;
    private JSlider blueSlider;
    private JSlider opacitySlider;
    private JLabel colorLabel;

    public ColorSelectorApp() {
        frame = new JFrame("Exercise 16_17");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        colorPanel = new JPanel();
        colorPanel.setLayout(new BorderLayout());

        colorLabel = new JLabel("Show Colors");
        colorLabel.setHorizontalAlignment(JLabel.CENTER);
        colorLabel.setFont(new Font("Arial", Font.PLAIN, 24));
        colorPanel.add(colorLabel, BorderLayout.CENTER);

        JPanel sliderPanel = new JPanel();
        sliderPanel.setLayout(new GridLayout(4, 2));

        redSlider = createSlider("Red");
        greenSlider = createSlider("Green");
        blueSlider = createSlider("Blue");
        opacitySlider = createSlider("Opacity");

        sliderPanel.add(new JLabel("Red:"));
        sliderPanel.add(redSlider);
        sliderPanel.add(new JLabel("Green:"));
        sliderPanel.add(greenSlider);
        sliderPanel.add(new JLabel("Blue:"));
        sliderPanel.add(blueSlider);
        sliderPanel.add(new JLabel("Opacity:"));
        sliderPanel.add(opacitySlider);

        frame.add(colorPanel, BorderLayout.CENTER);
        frame.add(sliderPanel, BorderLayout.SOUTH);

        redSlider.addChangeListener(new ColorSliderChangeListener());
        greenSlider.addChangeListener(new ColorSliderChangeListener());
        blueSlider.addChangeListener(new ColorSliderChangeListener());
        opacitySlider.addChangeListener(new ColorSliderChangeListener());

        frame.setVisible(true);
    }

    private JSlider createSlider(String label) {
        JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 100, 0);
        slider.setMajorTickSpacing(10);
        slider.setMinorTickSpacing(1);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);

        slider.setBorder(BorderFactory.createTitledBorder(label));

        return slider;
    }

    private class ColorSliderChangeListener implements ChangeListener {
        @Override
        public void stateChanged(ChangeEvent e) {
            int red = redSlider.getValue();
            int green = greenSlider.getValue();
            int blue = blueSlider.getValue();
            int opacity = opacitySlider.getValue();

            Color textColor = new Color(red, green, blue, opacity);
            colorLabel.setForeground(textColor);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ColorSelectorApp();
            }
        });
    }
}
