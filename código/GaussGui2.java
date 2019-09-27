import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.TableModel;

import net.miginfocom.swing.*;
/*
 * Created by JFormDesigner on Thu Sep 26 17:27:51 BRT 2019
 */



/**
 * @author unknown
 */
public class GaussGui2 extends JPanel {

    EliminacaoGauss eliminacaoGauss = new EliminacaoGauss();
    public GaussGui2() {
        initComponents();


    }

    private void button1ActionPerformed(ActionEvent e) {
       TableModel tA = tabelaA.getModel();
       TableModel tB = tabelaB.getModel();

        ArrayList<ArrayList<Float>> arrayA = new ArrayList<>();
        ArrayList<Float> arrayB = new ArrayList<>();

        // alimentando a matriz A
        for(int i = 0; i<10;i++){
            if (tabelaA.getValueAt(i,0)==null) break;
            arrayA.add(new ArrayList<>());

            for(int j = 0;j<10;j++){
                if (tabelaA.getValueAt(i,j)==null) break;
                arrayA.get(i).add(j, Float.parseFloat((String)tabelaA.getValueAt(i,j)));
            }
        }
        //alimentando a matriz B
        for(int i = 0; i<10;i++){
            if (tabelaB.getValueAt(i,0)==null) break;
            arrayB.add(i,  Float.parseFloat((String)tabelaB.getValueAt(i,0)));
            }


        float[][] matrizA = new float[arrayA.size()][];
        for(int i = 0; i<arrayA.size();i++){
            float aux[] = new float[arrayA.get(i).size()];
            for(int j =0;j<arrayA.size();j++){
                aux[j] = arrayA.get(i).get(j);
            }
            matrizA[i] = aux;
        }

        float[] matrizB = new float[arrayB.size()];
        for (int i=0;i<arrayB.size();i++){
            matrizB[i] = arrayB.get(i);
        }

        eliminacaoGauss.preencherMatrizA(matrizA);
        eliminacaoGauss.preencherMatrizB(matrizB);

        eliminacaoGauss.iterarK2();

        matrizA = eliminacaoGauss.getMatrizA();
        matrizB = eliminacaoGauss.getMatrizB();

        for(int i = 0;i<matrizA.length;i++){
            for(int j = 0;j<matrizA[i].length;j++){
                tabelaA.setValueAt(Float.toString(matrizA[i][j]),i,j);
            }
        }

        for(int i = 0;i<matrizB.length;i++){
            tabelaB.setValueAt(Float.toString(matrizB[i]),i,0);
        }

        CampoResultados.append(String.format("k = %d \n",eliminacaoGauss.getK()));

        //imprimindo os valores de x
        if(eliminacaoGauss.getK()==matrizA.length-1){
            float[] resultados = eliminacaoGauss.retornaValoresdeX();
            int k = 0;
            for (float i : resultados){
                CampoResultados.append(String.format("x%d = %f \n",k,i));
                k++;
            }

            //button1.setEnabled(false);
        }

    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Hugo Veltrini
        scrollPane1 = new JScrollPane();
        tabelaB = new JTable(10,1);
        scrollPane2 = new JScrollPane();
        tabelaA = new JTable(10,10);
        scrollPane3 = new JScrollPane();
        CampoResultados = new JTextArea();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        button1 = new JButton();

        //======== this ========
        setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax . swing. border .EmptyBorder (
        0, 0 ,0 , 0) ,  "JFor\u006dDesi\u0067ner \u0045valu\u0061tion" , javax. swing .border . TitledBorder. CENTER ,javax . swing. border .TitledBorder
        . BOTTOM, new java. awt .Font ( "Dia\u006cog", java .awt . Font. BOLD ,12 ) ,java . awt. Color .
        red ) , getBorder () ) );  addPropertyChangeListener( new java. beans .PropertyChangeListener ( ){ @Override public void propertyChange (java .
        beans. PropertyChangeEvent e) { if( "bord\u0065r" .equals ( e. getPropertyName () ) )throw new RuntimeException( ) ;} } );

        //======== scrollPane1 ========
        {

            //---- tabelaB ----
            tabelaB.setBorder(new MatteBorder(1, 1, 1, 1, Color.black));
            scrollPane1.setViewportView(tabelaB);
        }

        //======== scrollPane2 ========
        {
            scrollPane2.setViewportView(tabelaA);
        }

        //======== scrollPane3 ========
        {

            //---- CampoResultados ----
            CampoResultados.setBorder(new MatteBorder(1, 1, 1, 1, Color.black));
            scrollPane3.setViewportView(CampoResultados);
        }

        //---- label1 ----
        label1.setText("Matriz A");

        //---- label2 ----
        label2.setText("Matriz B");

        //---- label3 ----
        label3.setText("Resultado");

        //---- button1 ----
        button1.setText("Calcular");
        button1.addActionListener(e -> button1ActionPerformed(e));

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addGroup(layout.createParallelGroup()
                                .addComponent(label1)
                                .addComponent(scrollPane2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup()
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(0, 0, Short.MAX_VALUE)
                                    .addComponent(label2)
                                    .addGap(0, 0, Short.MAX_VALUE))
                                .addComponent(scrollPane1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)))
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(scrollPane3, GroupLayout.PREFERRED_SIZE, 452, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(button1, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, Short.MAX_VALUE)))
                    .addContainerGap())
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(label3)
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(5, 5, 5)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label1)
                        .addComponent(label2))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE)
                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE))
                    .addGap(12, 12, 12)
                    .addComponent(label3)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(button1, GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                        .addComponent(scrollPane3, GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE))
                    .addContainerGap(15, Short.MAX_VALUE))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Hugo Veltrini
    private JScrollPane scrollPane1;
    private JTable tabelaB;
    private JScrollPane scrollPane2;
    private JTable tabelaA;
    private JScrollPane scrollPane3;
    private JTextArea CampoResultados;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

}
