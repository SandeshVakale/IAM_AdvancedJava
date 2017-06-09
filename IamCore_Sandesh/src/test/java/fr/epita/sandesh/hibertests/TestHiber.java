package fr.epita.sandesh.hibertests;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.inject.Inject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.epita.sandesh.Services.Dao;
import fr.epita.sandesh.model.Address;
import fr.epita.sandesh.model.Etudiant;

/**s 
 * @author Sandesh VAKALE
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/applicationContext.xml"})

public class TestHiber {
	
	private static final Logger LOGGER = LogManager.getLogger(TestHiber.class);
	
	
	@Inject
	Dao <Etudiant>dao;
	@Inject
	Dao <Address>daoA;
	
	/**
	 * Testing etudiant Dao Methods
	 */
	@Test
	public void testEtudiant(){
	    
		Address address=new Address(101,"Mumabi","Fancy");	
		Etudiant etudiant=new Etudiant("sandesh","gmail",123,address);
		
		

		daoA.write(address);
		List<Address>Listad=daoA.searchBy("paris");
		Assert.assertTrue(Listad!=null && !Listad.isEmpty());
		LOGGER.info("Tested Write Method & searchBy from AddressDao",address);
		
		
		
		
		dao.write(etudiant);
		List<Etudiant>l=dao.listall();
		//Address ad=l.get(0).getAddress();
		//Assert.assertTrue(ad!=null);
		Assert.assertTrue(!l.isEmpty());
		LOGGER.info("Tested Methods",etudiant);
		
		
		
	    etudiant.setName("vakale");
	    dao.update(etudiant);
	    List<Etudiant>la=dao.listall();
	    String name=la.get(0).getName();
	    assertEquals(name,"sandesh");
		LOGGER.info("Tested Update Method",etudiant);
		
		//delete testing
		dao.delete(etudiant);
		List<Etudiant>lao=dao.listall();
		Assert.assertTrue(lao.isEmpty());
		LOGGER.info("Tested Delete Method",etudiant);
		
		
	}
	
	/**
	 * To test AddressDao 
	 */
	@Test
	public void TestAddress(){
		Address address=new Address(102,"Delhi","Shivu");
		
		daoA.write(address);
		List<Address>All_Result=daoA.listall();
		Assert.assertTrue(!All_Result.isEmpty());
		LOGGER.info("Tested  Methods",address);
		
		address.setCity("LYON");
		daoA.update(address);
		List<Address>Result=daoA.searchBy("LYON");
		Assert.assertTrue(Result!=null && !Result.isEmpty());
		LOGGER.info("Tested Methods",address);
		
		daoA.delete(address);
		List<Address>All_Resulta=daoA.listall();
		Assert.assertTrue(All_Resulta.isEmpty());
		LOGGER.info("Tested Method",address);
		
	}
	
	
	
	
	
}
