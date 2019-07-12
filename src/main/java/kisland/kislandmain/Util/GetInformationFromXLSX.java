package kisland.kislandmain.Util;

import kisland.kislandmain.DO.IncomeAndCharge.XlsxChargeDO;
import kisland.kislandmain.DO.IncomeAndCharge.XlsxIncomeDO;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 从配置文件中读取收付款信息
 */
@Service
public class GetInformationFromXLSX {
    /**
     * 从中区的配置文件中获取收款的信息
     * @param ExcelName
     * @return
     * @throws IOException
     * @throws InvalidFormatException
     */
    public  List<XlsxIncomeDO> GetIncomeInformation(String ExcelName) throws IOException, InvalidFormatException {
        File file = ResourceUtils.getFile("classpath:static/document/"+ExcelName);
        String ExcelPath = file.getAbsolutePath();
        List<XlsxIncomeDO> list = new ArrayList<>();
        Workbook workbook = WorkbookFactory.create(new FileInputStream(ExcelPath));
        Sheet sheet = workbook.getSheet("收款");
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            XlsxIncomeDO xlsxIncomeDO = new XlsxIncomeDO();
            //设置单元格类型
            if (row.getCell(0) != null) {
                row.getCell(0).setCellType(Cell.CELL_TYPE_STRING);
                String LegalSubject = row.getCell(0).getStringCellValue();
                xlsxIncomeDO.setLegalSubject(LegalSubject);
            }
            if (row.getCell(1) != null) {
                row.getCell(1).setCellType(Cell.CELL_TYPE_STRING);
                String BankName = row.getCell(1).getStringCellValue();
                xlsxIncomeDO.setBankName(BankName);
            }
            if (row.getCell(2) != null) {
                row.getCell(2).setCellType(Cell.CELL_TYPE_STRING);
                String BankAccount = row.getCell(2).getStringCellValue();
                xlsxIncomeDO.setBankAccount(BankAccount);
            }
            if (row.getCell(3) != null) {
                row.getCell(3).setCellType(Cell.CELL_TYPE_STRING);
                String OtherBankName = row.getCell(3).getStringCellValue();
                xlsxIncomeDO.setOtherBankName(OtherBankName);
            }
            if (row.getCell(4) != null) {
                row.getCell(4).setCellType(Cell.CELL_TYPE_STRING);
                String OtherBankAccount = row.getCell(4).getStringCellValue();
                xlsxIncomeDO.setOtherBankAccount(OtherBankAccount);
            }
            if (row.getCell(5) != null) {
                row.getCell(5).setCellType(Cell.CELL_TYPE_STRING);
                String ReceivingChannel = row.getCell(5).getStringCellValue();
                xlsxIncomeDO.setReceivingChannel(ReceivingChannel);
            }
            list.add(xlsxIncomeDO);
        }
        return list;
    }

    /**
     * 从xlsx中获取付款信息
     * @param ExcelName
     * @return
     * @throws IOException
     * @throws InvalidFormatException
     */
    public  List<XlsxChargeDO> GetChargeInformation(String ExcelName) throws IOException, InvalidFormatException {
        File file = ResourceUtils.getFile("classpath:static/document/"+ExcelName);
        String ExcelPath = file.getAbsolutePath();
        List<XlsxChargeDO> list = new ArrayList<>();
        Workbook workbook = WorkbookFactory.create(new FileInputStream(ExcelPath));
        Sheet sheet = workbook.getSheet("付款");
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            XlsxChargeDO xlsxChargeDO = new XlsxChargeDO();
            //设置单元格类型
            if (row.getCell(0) != null) {
                row.getCell(0).setCellType(Cell.CELL_TYPE_STRING);
                String LegalSubject = row.getCell(0).getStringCellValue();
                xlsxChargeDO.setLegalSubject(LegalSubject);
            }
            if (row.getCell(1) != null) {
                row.getCell(1).setCellType(Cell.CELL_TYPE_STRING);
                String BankName = row.getCell(1).getStringCellValue();
                xlsxChargeDO.setBankName(BankName);
            }
            if (row.getCell(2) != null) {
                row.getCell(2).setCellType(Cell.CELL_TYPE_STRING);
                String BankAccount = row.getCell(2).getStringCellValue();
                xlsxChargeDO.setBankAccount(BankAccount);
            }
            if (row.getCell(3) != null) {
                row.getCell(3).setCellType(Cell.CELL_TYPE_STRING);
                String OtherBankName = row.getCell(3).getStringCellValue();
                xlsxChargeDO.setOtherBankName(OtherBankName);
            }
            if (row.getCell(4) != null) {
                row.getCell(4).setCellType(Cell.CELL_TYPE_STRING);
                String OtherBankAccount = row.getCell(4).getStringCellValue();
                xlsxChargeDO.setOtherBankAccount(OtherBankAccount);
            }
            if (row.getCell(5) != null) {
                row.getCell(5).setCellType(Cell.CELL_TYPE_STRING);
                String ReceivingChannel = row.getCell(5).getStringCellValue();
                xlsxChargeDO.setOutputChannel(ReceivingChannel);
            }
            list.add(xlsxChargeDO);
        }
        return list;
    }


}
