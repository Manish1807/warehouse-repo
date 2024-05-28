package sa.tabadul.pcs.warehouse.repository.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import sa.tabadul.pcs.warehouse.actuate.common.ConstantValues;
import sa.tabadul.pcs.warehouse.api.v1.request.FilterRequest;
import sa.tabadul.pcs.warehouse.api.v1.request.PaginationRequestModel;
import sa.tabadul.pcs.warehouse.domain.SpaceBookingEntity;

public class SpaceBookingSpecification implements Specification<SpaceBookingEntity>{
    private final PaginationRequestModel pagination = new PaginationRequestModel();
    @Override
    public Predicate toPredicate(Root<SpaceBookingEntity> root, CriteriaQuery<?> query,
            CriteriaBuilder criteriaBuilder) {
        Predicate predicate = criteriaBuilder.conjunction();
		filterOrgId(criteriaBuilder, predicate, root, pagination.getKeys().getOrgID());
		filterBranchId(criteriaBuilder, predicate, root, pagination.getKeys().getBranchID());
		filterPortId(criteriaBuilder, predicate, root, pagination.getKeys().getPortID());

		// String search = pagination.getSearch();
		// FilterRequest filter = pagination.getFilter() != null ? pagination.getFilter() : null;
		// if (filter != null) {
		// 	if (filter.getPortContractorByOrg() != null || filter.getPortContractorByBranch() != null || filter.getCargoType() != null || filter.getFromDate() != null
		// 			|| filter.getToDate() != null || filter.getLongLastingDays() != null) {
		// 		// filterCargoType(predicate, root, filterCargoType, filter);
		// 		filterPortContractorByOrg(criteriaBuilder, predicate, root, filter.getPortContractorByOrg());
		// 		filterPortContractorByBranch(criteriaBuilder, predicate, root, filter.getPortContractorByBranch());
		// 		filterFromDate(criteriaBuilder, predicate, root, filter.getFromDate());
		// 		filterToDate(criteriaBuilder, predicate, root, filter.getToDate());
		// 		filterLongLastingDate(criteriaBuilder, predicate,root, filter.getLongLastingDays());
		// 	}
		// 	return predicate;
		// } else if (!search.isEmpty()) {
		// 	Predicate searchPredicate = searchContainerInventory(root, criteriaBuilder, search,
		// 			searchVoyageRid, searchCargoType, searchShippingType);
		// 	return criteriaBuilder.and(predicate, searchPredicate);
		// } else {
		// 	return predicate;
		// }
        return predicate;
    }
    private void filterPortId(CriteriaBuilder criteriaBuilder, Predicate predicate, Root<SpaceBookingEntity> root,
            			Integer portID){
                if(portID != null && portID != 0 ) {
                    predicate.getExpressions().add(criteriaBuilder.equal(root.get(""), portID));
                }
    }
    private void filterBranchId(CriteriaBuilder criteriaBuilder, Predicate predicate, Root<SpaceBookingEntity> root,
            String branchID) {
                if(branchID!= null && !branchID.isEmpty()) {
                    predicate.getExpressions().add(criteriaBuilder.equal(root.get(""), branchID));
                };
    }
    private void filterOrgId(CriteriaBuilder criteriaBuilder, Predicate predicate, Root<SpaceBookingEntity> root,
            String orgID) {
       if(orgID!= null && !orgID.isEmpty()) {
			predicate.getExpressions().add(criteriaBuilder.equal(root.get(""), orgID));
		}
    }


    
}
