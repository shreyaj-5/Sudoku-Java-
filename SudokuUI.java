import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class SudokuUI extends JFrame {

	private JButton[][] buttons;
	private ActionListener[][] actionListener;
	private JPanel[][] blocks;
	private Sudoku sudoku;
	private int gameMode;
	private int grid;

	/** Creates new form UI */
	public SudokuUI() {
		sudoku = new Sudoku();
		gameMode = Sudoku.GAME_MODE_MEDIUM;
		grid = Sudoku.GRID_9X9;
		initComponents();
		initialize();

	}

	private void initComponents() {

		base = new JPanel();
		options = new JPanel();
		newGameBut = new JButton();
		resetGameBut = new JButton();
		submit = new JButton();
		holder = new JPanel();
		board = new JPanel();
		menue = new JMenuBar();
		game = new JMenu();
		newGame = new JMenuItem();
		resetGame = new JMenuItem();
		jSeparator1 = new JPopupMenu.Separator();
		exit = new JMenuItem();
		jMenu2 = new JMenu();
		beginner = new JRadioButtonMenuItem();
		intermediator = new JRadioButtonMenuItem();
		expert = new JRadioButtonMenuItem();
		help = new JMenu();
		about = new JMenuItem();

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Sudoku");
		setMinimumSize(new Dimension(500, 500));

		base.setBackground(Color.WHITE);

		options.setBackground(Color.WHITE);

		newGameBut.setBackground(Color.WHITE);
		newGameBut.setFont(new Font("Tahoma", 0, 12));
		newGameBut.setText("New Game");
		newGameBut.setSize(63, 19);
		newGameBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				newGameButActionPerformed(evt);
			}
		});

		resetGameBut.setBackground(Color.WHITE);
		resetGameBut.setFont(new Font("Tahoma", 0, 12));
		resetGameBut.setText("Reset Game");
		resetGameBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				resetGameButActionPerformed(evt);
			}
		});

		submit.setBackground(new Color(255, 255, 255));
		submit.setFont(new Font("Tahoma", 0, 12));
		submit.setText("Submit");
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				submitActionPerformed(evt);
			}
		});

		GroupLayout optionsLayout = new GroupLayout(options);
		optionsLayout.setHorizontalGroup(optionsLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(optionsLayout.createSequentialGroup().addGap(100)
						.addComponent(newGameBut, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(resetGameBut, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
						.addGap(12).addComponent(submit, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 65, Short.MAX_VALUE).addContainerGap()));
		optionsLayout.setVerticalGroup(optionsLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(optionsLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(newGameBut, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
						.addComponent(submit, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(resetGameBut, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))

		);

		options.setLayout(optionsLayout);

		holder.setBackground(new Color(255, 255, 255));
		holder.setLayout(new GridLayout(1, 1));

		board.setBackground(Color.GRAY);
		board.setSize(100, 100);
		board.setLayout(new GridLayout(9, 9));
		holder.add(board);

		GroupLayout baseLayout = new GroupLayout(base);
		base.setLayout(baseLayout);
		baseLayout.setHorizontalGroup(baseLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(GroupLayout.Alignment.TRAILING, baseLayout.createSequentialGroup().addContainerGap()
						.addGroup(baseLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
								.addComponent(holder, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 572,
										Short.MAX_VALUE)
								.addComponent(options, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
										GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addContainerGap()));
		baseLayout.setVerticalGroup(baseLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(baseLayout
				.createSequentialGroup().addContainerGap()
				.addComponent(options, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
				.addComponent(holder, GroupLayout.DEFAULT_SIZE, 534, Short.MAX_VALUE).addContainerGap()));

		game.setText("Game");
		newGame.setText("New Game");
		newGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				newGameActionPerformed(evt);
			}
		});
		game.add(newGame);

		resetGame.setText("Reset Game");
		resetGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				resetGameActionPerformed(evt);
			}
		});
		game.add(resetGame);
		game.add(jSeparator1);

		exit.setText("Exit");
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				exitActionPerformed(evt);
			}
		});
		game.add(exit);

		menue.add(game);

		jMenu2.setText("Level");

		beginner.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, InputEvent.CTRL_MASK));
		beginner.setText("Beginner");
		beginner.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				beginnerActionPerformed(evt);
			}
		});
		jMenu2.add(beginner);

		intermediator.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, InputEvent.CTRL_MASK));
		intermediator.setSelected(true);
		intermediator.setText("Intermediator");
		intermediator.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				intermediatorActionPerformed(evt);
			}
		});
		jMenu2.add(intermediator);

		expert.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_MASK));
		expert.setText("Expart");
		expert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				expertActionPerformed(evt);
			}
		});
		jMenu2.add(expert);

		menue.add(jMenu2);

		help.setText("Help");

		about.setText("About");
		about.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				aboutActionPerformed(evt);
			}
		});
		help.add(about);

		menue.add(help);

		setJMenuBar(menue);

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(base,
				GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(base,
				GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

		pack();
	}

	private void newGameActionPerformed(ActionEvent evt) {
		grid = Sudoku.GRID_9X9;
		int[][] puzzle = sudoku.getNewPuzzle(grid, gameMode);
		createBoard(puzzle);
	}

	private void resetGameActionPerformed(ActionEvent evt) {
		int[][] puzzle = sudoku.resetPuzzle();
		createBoard(puzzle);
	}

	private void intermediatorActionPerformed(ActionEvent evt) {
		gameMode = Sudoku.GAME_MODE_MEDIUM;
		int[][] puzzle = sudoku.getNewPuzzle(grid, gameMode);
		createBoard(puzzle);
	}

	private void expertActionPerformed(ActionEvent evt) {
		gameMode = Sudoku.GAME_MODE_EXPERT;
		int[][] puzzle = sudoku.getNewPuzzle(grid, gameMode);

	}

	private void exitActionPerformed(ActionEvent evt) {
		System.exit(0);
	}

	private void beginnerActionPerformed(ActionEvent evt) {
		gameMode = Sudoku.GAME_MODE_EASY;
		int[][] puzzle = sudoku.getNewPuzzle(grid, gameMode);
		createBoard(puzzle);
	}

	private void resetGameButActionPerformed(ActionEvent evt) {
		int[][] puzzle = sudoku.resetPuzzle();
		createBoard(puzzle);
	}

	private void newGameButActionPerformed(ActionEvent evt) {
		int[][] puzzle = sudoku.getNewPuzzle(grid, gameMode);
		createBoard(puzzle);
	}

	private void submitActionPerformed(ActionEvent evt) {
		if (!isAnsComplete()) {
			JOptionPane.showMessageDialog(this, "Please complete your answer.");
		} else {
			boolean isAnsCorrect = sudoku.check(getAns());
			String messageStr = "";
			if (isAnsCorrect) {
				messageStr = "Congratulation You have won the Game";
			} else {
				messageStr = "Sorry You have failed. ";
			}
			showMessage(messageStr);
		}
	}

	private void aboutActionPerformed(ActionEvent evt) {
		JOptionPane.showMessageDialog(this,
				"Version: 1.0.0\nBy: Sadhvi, Shreya, Kamalpreet\nDeveloped at University of the Fraser Valley");
	}

	private void createBoard(int[][] puzzle) {
		board.removeAll();
		grid = 9;
		blocks = new JPanel[grid][grid];
		buttons = new JButton[grid][grid];
		actionListener = new ActionListener[grid][grid];
		board.setLayout(new GridLayout(grid, grid, 3, 3));

		int rowsInGrid = 3;

		for (int i = 0; i < grid; i++) {
			for (int j = 0; j < grid; j++) {
				blocks[i][j] = new JPanel();
				buttons[i][j] = new JButton();
				String text = "";
				if (0 < puzzle[i][j] && puzzle[i][j] <= grid) {
					text += puzzle[i][j];
				} else {
					final JButton tempbutton = buttons[i][j];
					final JPanel tempBlock = blocks[i][j];
					actionListener[i][j] = new ActionListener() {

						public void actionPerformed(ActionEvent e) {
							viewInputs(tempBlock, tempbutton, grid);
						}
					};
					buttons[i][j].addActionListener(actionListener[i][j]);
				}
				buttons[i][j].setText(text);
				buttons[i][j].setFont(new Font("Tahoma", 0, 24));

				if (((0 <= i && i < rowsInGrid) || (rowsInGrid * 2 <= i && i < grid)) && (3 <= j && j < 6)) {
					buttons[i][j].setBackground(new Color(204, 204, 204));
				} else if ((rowsInGrid <= i && i < rowsInGrid * 2) && ((0 <= j && j < 3) || (6 <= j && j < 9))) {
					buttons[i][j].setBackground(new Color(204, 204, 204));
				} else {
					buttons[i][j].setBackground(new Color(255, 255, 255));
				}
				blocks[i][j].setLayout(new GridLayout(1, 1));
				blocks[i][j].add(buttons[i][j]);
				board.add(blocks[i][j]);
			}
		}

		holder.removeAll();
		holder.add(board);
		board.repaint();
		holder.repaint();
		this.setVisible(true);

	}

	private void initialize() {
		int[][] puzzle = sudoku.getNewPuzzle(grid, gameMode);
		createBoard(puzzle);
	}

	private void viewInputs(JPanel block, JButton inputButtton, int numOfInput) {
		JPanel inputs = new Inputs(this, block, inputButtton, numOfInput);
		block.remove(inputButtton);
		block.add(inputs);
		this.setVisible(true);
	}

	public void setInput(String ans, JPanel block, JButton inputButtton) {
		block.removeAll();
		inputButtton.setText(ans);
		inputButtton.setFont(new Font("Tahoma", 1, 24));
		block.add(inputButtton);
		this.repaint();
	}

	private int[][] getAns() {
		int ans[][] = new int[grid][grid];

		for (int i = 0; i < grid; i++) {
			for (int j = 0; j < grid; j++) {
				try {
					ans[i][j] = Integer.parseInt(buttons[i][j].getText());
				} catch (NumberFormatException e) {
					ans[i][j] = 0;
				}
			}
		}

		return ans;
	}

	private boolean isAnsComplete() {
		boolean isAnsComplete = true;
		for (int i = 0; i < grid; i++) {
			for (int j = 0; j < grid; j++) {
				try {
					Integer.parseInt(buttons[i][j].getText());
				} catch (NumberFormatException e) {
					isAnsComplete = false;
					break;
				}
			}
		}
		return isAnsComplete;
	}

	private void showMessage(String message) {
		JLabel messageLabel = new JLabel();
		messageLabel.setFont(new Font("Tahoma", 1, 20));
		messageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		messageLabel.setText(message);
		holder.removeAll();
		holder.add(messageLabel);
		holder.repaint();
		this.setVisible(true);
	}

	// Variables declaration
	private JMenuItem about;
	private JPanel base;
	private JRadioButtonMenuItem beginner;
	private JPanel board;
	private JMenuItem exit;
	private JRadioButtonMenuItem expert;
	private JMenu game;
	private JMenu help;
	private JPanel holder;
	private JRadioButtonMenuItem intermediator;
	private JMenu jMenu2;
	private JPopupMenu.Separator jSeparator1;
	private JMenuBar menue;
	private JMenuItem newGame;
	private JButton newGameBut;
	private JPanel options;
	private JMenuItem resetGame;
	private JButton resetGameBut;
	private JButton submit;
	private JLabel timeLabel;

}
