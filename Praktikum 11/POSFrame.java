import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.print.PrinterException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class POSFrame extends JFrame {

    private final List<Product> products = new ArrayList<>();
    private final List<CartItem> cart = new ArrayList<>();

    private JTable productTable;
    private JTable cartTable;
    private JTextField qtyField;
    private JLabel selectedLabel;
    private JLabel totalLabel;
    private JLabel pointsLabel;
    private JTextArea receiptArea;
    private DefaultTableModel productModel;
    private DefaultTableModel cartModel;

    private JButton addButton;
    private JButton checkoutButton;
    private JButton printButton;

    public POSFrame() {
        setTitle("POIN Off-Sales - Java Swing");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initProductData();
        initComponents();
        bindEvents();

        setSize(1000, 650);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // ================= DATA =================
    private void initProductData() {
        products.add(new Product("P001", "Air Mineral 600ml", 3000));
        products.add(new Product("P002", "Kopi Sachet", 5000));
        products.add(new Product("P003", "Roti isi", 8000));
        products.add(new Product("P004", "Snack Keripik", 6000));
        products.add(new Product("P005", "Minuman Botol", 12000));
    }

    // ================= TAMPILAN =================
    private void initComponents() {
        setLayout(new BorderLayout());

        // ---- Menu ----
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem exitItem = new JMenuItem("Exit");
        JMenu helpMenu = new JMenu("Help");
        JMenuItem aboutItem = new JMenuItem("About");

        exitItem.addActionListener(e -> dispose());
        aboutItem.addActionListener(e -> JOptionPane.showMessageDialog(
                this,
                "POIN Off-Sales - Praktikum Java Swing"));

        fileMenu.add(exitItem);
        helpMenu.add(aboutItem);
        menuBar.add(fileMenu);
        menuBar.add(helpMenu);
        setJMenuBar(menuBar);

        // ---- Panel Produk (BorderLayout) ----
        productModel = new DefaultTableModel(
                new Object[] { "ID", "Nama Produk", "Harga (Rp)" }, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        for (Product p : products) {
            productModel.addRow(new Object[] {
                    p.getId(), p.getName(), p.getPrice()
            });
        }
        productTable = new JTable(productModel);
        productTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        selectedLabel = new JLabel("Pilih produk dari tabel di kiri");
        qtyField = new JTextField("1", 4);
        addButton = new JButton("Add to Cart");

        JPanel qtyRow = new JPanel(new FlowLayout(FlowLayout.LEFT));
        qtyRow.add(new JLabel("Qty:"));
        qtyRow.add(qtyField);
        qtyRow.add(addButton);

        JPanel productSouth = new JPanel(new GridLayout(2, 1));
        productSouth.add(selectedLabel);
        productSouth.add(qtyRow);

        JPanel productPanel = new JPanel(new BorderLayout(0, 6));
        productPanel.setBorder(BorderFactory.createTitledBorder("Produk"));
        productPanel.add(new JScrollPane(productTable), BorderLayout.CENTER);
        productPanel.add(productSouth, BorderLayout.SOUTH);

        // ---- Panel Keranjang (BorderLayout) ----
        cartModel = new DefaultTableModel(
                new Object[] { "ID", "Nama Produk", "Qty", "Harga", "Subtotal" }, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        cartTable = new JTable(cartModel);

        totalLabel = new JLabel("Total: Rp0,00");
        totalLabel.setFont(totalLabel.getFont().deriveFont(Font.BOLD, 16f));
        pointsLabel = new JLabel("Points: 0");
        checkoutButton = new JButton("Checkout");
        printButton = new JButton("Cetak");

        JPanel buttonRow = new JPanel(new FlowLayout(FlowLayout.LEFT));
        buttonRow.add(checkoutButton);
        buttonRow.add(printButton);

        JPanel summaryPanel = new JPanel(new GridLayout(3, 1));
        summaryPanel.add(totalLabel);
        summaryPanel.add(pointsLabel);
        summaryPanel.add(buttonRow);

        receiptArea = new JTextArea(8, 30);
        receiptArea.setEditable(false);
        receiptArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
        JScrollPane receiptScroll = new JScrollPane(receiptArea);
        receiptScroll.setBorder(BorderFactory.createTitledBorder("Struk:"));

        JPanel cartSouth = new JPanel(new BorderLayout(0, 6));
        cartSouth.add(summaryPanel, BorderLayout.NORTH);
        cartSouth.add(receiptScroll, BorderLayout.CENTER);

        JPanel cartPanel = new JPanel(new BorderLayout(0, 6));
        cartPanel.setBorder(BorderFactory.createTitledBorder("Keranjang"));
        cartPanel.add(new JScrollPane(cartTable), BorderLayout.CENTER);
        cartPanel.add(cartSouth, BorderLayout.SOUTH);

        // ---- Gabungkan: GridLayout(1, 2) ----
        JPanel mainPanel = new JPanel(new GridLayout(1, 2, 8, 0));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
        mainPanel.add(productPanel);
        mainPanel.add(cartPanel);
        add(mainPanel, BorderLayout.CENTER);
    }

    // ================= EVENT =================
    private void bindEvents() {
        productTable.getSelectionModel().addListSelectionListener(e -> {
            if (e.getValueIsAdjusting())
                return;
            int row = productTable.getSelectedRow();
            if (row >= 0) {
                Product selected = products.get(row);
                selectedLabel.setText(
                        "Dipilih: " + selected.getId() +
                                " - " + selected.getName() +
                                " (" + formatRp(selected.getPrice()) + ")");
            }
        });

        addButton.addActionListener(e -> addSelectedProductToCart());
        checkoutButton.addActionListener(e -> checkout());
        printButton.addActionListener(e -> printReceipt());
    }

    // ================= LOGIKA =================
    private void addSelectedProductToCart() {
        int row = productTable.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this,
                    "Pilih produk terlebih dahulu.",
                    "Produk belum dipilih",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        int qty;
        try {
            qty = Integer.parseInt(qtyField.getText().trim());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                    "Qty harus berupa angka bulat.",
                    "Input tidak valid",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (qty <= 0) {
            JOptionPane.showMessageDialog(this,
                    "Qty harus lebih dari 0.",
                    "Input tidak valid",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        cart.add(new CartItem(products.get(row), qty));
        refreshCartTable();
        updateSummary();
        qtyField.setText("1");
    }

    private void refreshCartTable() {
        cartModel.setRowCount(0);
        for (CartItem item : cart) {
            Product p = item.getProduct();
            cartModel.addRow(new Object[] {
                    p.getId(),
                    p.getName(),
                    item.getQty(),
                    p.getPrice(),
                    item.getSubtotal()
            });
        }
    }

    private int calculateTotal() {
        int total = 0;
        for (CartItem item : cart) {
            total += item.getSubtotal();
        }
        return total;
    }

    private void updateSummary() {
        int total = calculateTotal();
        int points = total / 1000; // pembagian integer
        totalLabel.setText("Total: " + formatRp(total));
        pointsLabel.setText("Points: " + points);
    }

    private void checkout() {
        if (cart.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Keranjang masih kosong.",
                    "Checkout gagal",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        // 1. Buat struk SEBELUM keranjang dibersihkan
        int total = calculateTotal();
        int points = total / 1000;

        StringBuilder receipt = new StringBuilder();
        receipt.append("===== POIN OFF-SALES =====\n");
        receipt.append("Toko: Demo Toko\n");
        receipt.append("==========================\n");
        for (CartItem item : cart) {
            receipt.append(item.getProduct().getName()).append("\n");
            receipt.append(String.format("  %d x %s = %s%n",
                    item.getQty(),
                    formatRp(item.getProduct().getPrice()),
                    formatRp(item.getSubtotal())));
        }
        receipt.append("--------------------------\n");
        receipt.append("Total  : ").append(formatRp(total)).append("\n");
        receipt.append("Points : ").append(points).append("\n");
        receipt.append("==========================\n");
        receipt.append("Terima kasih telah berbelanja!\n");

        receiptArea.setText(receipt.toString());
        receiptArea.setCaretPosition(0);

        // 2. Kosongkan keranjang, reset total & points (struk tetap tampil)
        cart.clear();
        refreshCartTable();
        updateSummary();
    }

    private void printReceipt() {
        if (receiptArea.getText().isBlank()) {
            JOptionPane.showMessageDialog(this,
                    "Belum ada struk yang dapat dicetak.");
            return;
        }
        try {
            receiptArea.print();
        } catch (PrinterException ex) {
            JOptionPane.showMessageDialog(this,
                    "Gagal mencetak: " + ex.getMessage());
        }
    }

    // ================= UTIL =================
    private String formatRp(int amount) {
        return "Rp" + String.format(Locale.US, "%,d", amount).replace(',', '.');
    }
}