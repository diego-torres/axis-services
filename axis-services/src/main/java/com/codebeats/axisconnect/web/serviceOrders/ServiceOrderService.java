/**
 * 
 */
package com.codebeats.axisconnect.web.serviceOrders;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author dtorresf
 *
 */
@Component
public class ServiceOrderService {

	@Autowired
	private PartialServiceOrderRepository psoRepository;

	public void addPartialServiceOrder(PartialServiceOrder pso, String principal) {
		PartialServiceOrderComment psoc = new PartialServiceOrderComment();
		psoc.setComment("ORDER CREATED by " + principal);
		psoc.setFromUser("system");
		pso.addComment(psoc);
		psoRepository.save(pso);
	}

	public void updatePartialServiceOrder(PartialServiceOrder pso) {
		psoRepository.save(pso);
	}

	public PartialServiceOrder getPartialServiceOrderById(Integer id) {
		return psoRepository.findById(id).orElse(null);
	}

	/**
	 * 
	 * @return
	 */
	public List<ServiceOrder> getActiveServiceOrders() {
		List<ServiceOrder> result = new ArrayList<>();
		Random r = new Random();
		for (int i = 1; i <= 50; i++) {
			result.add(new ServiceOrder(r.nextInt(1000), randomBoolean(4), randomOrder(5), randomOrder(7),
					randomDate((int) LocalDate.now().toEpochDay() - 30), randomDate((int) LocalDate.now().toEpochDay()),
					randomDate((int) LocalDate.now().toEpochDay()), randomDate((int) LocalDate.now().toEpochDay()),
					getShipper(r.nextInt(10)), getConsignee(r.nextInt(10)), "Autoparts", "Fedex", "LTL", "BOOKED",
					r.nextInt(100), "LTL", randomOrder(5), randomOrder(5), randomOrder(5), r.nextInt(100)));
		}

		List<PartialServiceOrder> psoList = new ArrayList<>();
		psoRepository.findAll().spliterator().forEachRemaining(psoList::add);
		result.addAll(psoList.stream()
				.map(pso -> new ServiceOrder(pso.getId(), false, pso.getCustomerRef(), pso.getVendorRef(), null, null,
						null, pso.getDeliveryDate(), null, null, "IN PROGRESS ORDER ENTRY", null, null, "ORDER ENTRY",
						0, null, null, null, null, null))
				.collect(Collectors.toList()));

		return result;
	}

	/**
	 * 
	 * @return
	 */
	public List<ServiceOrder> getClosedServiceOrders() {
		List<ServiceOrder> result = new ArrayList<>();
		Random r = new Random();
		for (int i = 1; i <= 50; i++) {
			result.add(new ServiceOrder(r.nextInt(1000), randomBoolean(4), randomOrder(5), randomOrder(7),
					randomDate((int) LocalDate.now().toEpochDay() - 30), randomDate((int) LocalDate.now().toEpochDay()),
					randomDate((int) LocalDate.now().toEpochDay()), randomDate((int) LocalDate.now().toEpochDay()),
					getShipper(r.nextInt(10)), getConsignee(r.nextInt(10)), "Autoparts", "Fedex", "LTL", "CLOSED",
					r.nextInt(100), "LTL", randomOrder(5), randomOrder(5), randomOrder(5), r.nextInt(100)));
		}

		return result;
	}

	private String getShipper(int shipperId) {
		switch (shipperId) {
		case 0:
			return "Saia Burgess / Johnson Elec.";
		case 1:
			return "Nowgroup Inc.";
		case 2:
			return "Nowgroup Inc.";
		case 3:
			return "Nowgroup Inc.";
		case 4:
			return "Valeo SLP";
		case 5:
			return "Cebi / Huamantla";
		case 6:
			return "Nuevo Laredo";
		case 7:
			return "NG Laredo";
		case 8:
			return "Axis Connect US";
		case 9:
			return "Valeo SLP";
		default:
			return "Axis Connect US";
		}
	}

	private String getConsignee(int id) {
		switch (id) {
		case 0:
			return "Baxter - TN";
		case 1:
			return "Baxter - TN";
		case 2:
			return "AI";
		case 3:
			return "AI";
		case 4:
			return "NG Laredo";
		case 5:
			return "Airtemp Puebla";
		case 6:
			return "Airtemp Puebla";
		case 7:
			return "NG Laredo";
		case 8:
			return "Axis Connect US";
		case 9:
			return "Valeo SLP";
		default:
			return "Axis Connect US";
		}
	}

	private boolean randomBoolean(int truePct) {
		double rnd = Math.random() * 10;
		return rnd < truePct;
	}

	private String randomOrder(int length) {
		StringBuilder sb = new StringBuilder();
		Random r = new Random();
		for (int i = 0; i < length; i++) {
			sb.append(r.nextInt(10));
		}
		return sb.toString();
	}

	private Date randomDate(int minDay) {
		Random random = new Random();
		// int minDay = (int) LocalDate.now().toEpochDay();
		int maxDay = (int) LocalDate.now().plusDays(15).toEpochDay();
		long randomDay = minDay + random.nextInt(maxDay - minDay);

		return Date.from(LocalDate.ofEpochDay(randomDay).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());

	}

}
