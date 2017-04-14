/*
package sample;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.jfree.data.general.DefaultPieDataset;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.stage.Stage;
 
public class PieChartSample extends Application {
	Connection con;
	
	public PieChartSample(Connection con) {
		this.con=con;
	}
	
	public void getGenderData(){//�����м�
		PreparedStatement pstmt=null;
		ResultSet rs=null;

		StringBuffer sql=new StringBuffer();
		
		sql.append("select gender, count(gender), count(*) as �����ڼ�,");
		sql.append(" (select count(*) from score) as �հ�,");
		sql.append("	count(*)/(select count(*) from score)*100 as ����");  
		sql.append("	from score group by gender");

		try {
			pstmt=con.prepareStatement(sql.toString());
			rs=pstmt.executeQuery();
			
			//�����͸� �ɱ����� �̹� dataSet�� �����ؾ���
			dataSet=new DefaultPieDataset();
			
			while(rs.next()){
				dataSet.setValue(rs.getString("grade"), rs.getInt("����"));			
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt!=null){
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}           
	
    @Override 
    public void start(Stage stage) {
        Scene scene = new Scene(new Group());
        stage.setTitle("Imported Fruits");
        stage.setWidth(500);
        stage.setHeight(500);
 
        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                new PieChart.Data("Grapefruit", 13),
                new PieChart.Data("Oranges", 25),
                new PieChart.Data("Plums", 10),
                new PieChart.Data("Pears", 22),
                new PieChart.Data("Apples", 30));
        final PieChart chart = new PieChart(pieChartData);
        chart.setTitle("Imported Fruits");

        ((Group) scene.getRoot()).getChildren().add(chart);
        stage.setScene(scene);
        stage.show();
    }
 
    public static void main(String[] args) {
        launch(args);
    }
}*/