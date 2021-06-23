package repository;

import model.Contract;
import model.Customer;
import model.Employee;
import model.Service;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContractRepositoryImpl implements ContractRepository {
    @Override
    public List<Contract> selectAllContract() {
        Connection connection=DBConnection.getConnection();
        CallableStatement callableStatement=null;
        ResultSet resultSet=null;
        List<Contract> contractList=new ArrayList<>();
        try {
            callableStatement =connection.prepareCall("call selectAllContract()");
            resultSet= callableStatement.executeQuery();
            while (resultSet.next()){
                int contractId=resultSet.getInt("contractid");
                int customerId=resultSet.getInt("customerid");
                String customerName=resultSet.getString("customername");
                Customer customer=new Customer(customerId,customerName);
                String serviceId=resultSet.getString("serviceid");
                String serviceName=resultSet.getString("servicename");
                Service service=new Service(serviceId,serviceName);
                int employeeId=resultSet.getInt("employeeid");
                String employeeName=resultSet.getString("name");
                Employee employee=new Employee(employeeId,employeeName);
                String beginDate=resultSet.getString("begindate");
                String finishDate=resultSet.getString("finishdate");
                int firstPayment=resultSet.getInt("firstpayment");
                int totalPayment=resultSet.getInt("totalpayment");
                Contract contract=new Contract(contractId,customer,service,employee,beginDate,finishDate,firstPayment,totalPayment);
                contractList.add(contract);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contractList;
    }

    @Override
    public void save(Contract contract) {
        Connection connection=DBConnection.getConnection();
        CallableStatement callableStatement=null;
        try {
            callableStatement=connection.prepareCall("call insertContract(?,?,?,?,?,?,?)");
            callableStatement.setInt(1,contract.getCustomer().getCustomerId());
            callableStatement.setString(2,contract.getService().getServiceId());
            callableStatement.setInt(3,contract.getEmployee().getEmployeeId());
            callableStatement.setString(4,contract.getBeginDate());
            callableStatement.setString(5,contract.getFinishDate());
            callableStatement.setInt(6,contract.getFirstPayment());
            callableStatement.setInt(7,contract.getTotalPayment());
            callableStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                callableStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            DBConnection.close();
        }

    }

    @Override
    public Contract findContractById(int contractId) {
        return null;
    }
}
