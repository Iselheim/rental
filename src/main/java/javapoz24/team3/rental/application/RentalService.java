package javapoz24.team3.rental.application;

import javapoz24.team3.rental.domain.rental.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RentalService {

    private final RentalDomainService rentalDomainService;

    public RentalService(RentalDomainService rentalDomainService) {
        this.rentalDomainService = rentalDomainService;
    }

    public RentalDTO getRentalInfo() {
        return RentalDTO.fromRental(rentalDomainService.getRentalInfo());
    }

    public void saveRentalInfoData(Rental rental) {
        rentalDomainService.saveRentalInfoData(rental);
    }

    public void saveBranch(CompanyBranch branch) {
        rentalDomainService.saveBranch(branch);
    }

    public List<CompanyBranchDTO> getAllBranches() {
        return rentalDomainService.getAllBranches().stream()
                .map(CompanyBranchDTO::fromCompanyBranch)
                .collect(Collectors.toList());
    }

    public CompanyBranchDTO getBranchById(Long id) {
        return CompanyBranchDTO.fromCompanyBranch(rentalDomainService.getBranchById(id));
    }
}
