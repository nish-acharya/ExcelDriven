import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class dataDriven {
   public ArrayList<String> getData(String Login) throws IOException
   {
	   ArrayList<String> a = new ArrayList<String>();
		FileInputStream fl = new FileInputStream("C:\\Users\\nischitha.dn\\OneDrive\\Documents\\demoData.xlsx");
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(fl);
		
		int sheets = workbook.getNumberOfSheets();
		for(int i = 0; i<sheets ; i++)
		{
			if(workbook.getSheetName(i).equalsIgnoreCase("test1"))
			{
				XSSFSheet sheet = workbook.getSheetAt(i);
				java.util.Iterator<Row> rows =  sheet.iterator();
				Row firstrow = rows.next();
				java.util.Iterator<Cell> cel=firstrow.cellIterator();
				int k=0;
				int clm=0;
				while(cel.hasNext())
				{
					Cell value = cel.next();
					if(value.getStringCellValue().equalsIgnoreCase("TestCases"))
					{
						clm=k;
					}
					k++;
				}
				System.out.println(clm);
				
				while(rows.hasNext())
				{
					Row r = rows.next();
					if(r.getCell(clm).getStringCellValue().equalsIgnoreCase(Login))
					{
						java.util.Iterator<Cell> cv=r.cellIterator();
						while(cv.hasNext())
						{
							//System.out.println(cv.next().getStringCellValue());
							Cell c = cv.next();
							if(c.getCellType()==CellType.STRING)
							{
							a.add(c.getStringCellValue());
							}
							else {
								
								a.add(NumberToTextConverter.toText(c.getNumericCellValue()));
										
							}
						}
						
					}
				}
				
				
				
				
			}
		//	return a;
		}
		return a;
		
   }

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		
		
		

	}

}
