import Modal from "@/components/layout/modal";

interface PickupPointModalProps {
	isModalOpen: boolean;
	handleCloseModal: () => void;
	handleSelectAddress: (address: string) => void;
}

const availableAddresses = [
	{ code: "КРД-001", address: "ул. Ставрпопольская, 149" },
	{ code: "КРД-002", address: "ул. Ставрпопольская, 150" },
	{ code: "КРД-003", address: "ул. Ставрпопольская, 151" },
	{ code: "КРД-004", address: "ул. Ставрпопольская, 152" },
];

export const PickupPointModal = ({
	isModalOpen,
	handleCloseModal,
	handleSelectAddress,
}: PickupPointModalProps) => {
	return (
		<Modal isOpen={isModalOpen} onClose={handleCloseModal}>
			<h3 className="font-semibold text-center text-lg mb-3">Пункт выдачи</h3>
			<div className="flex flex-col gap-2">
				{availableAddresses.map(address => (
					<div
						className="grid grid-cols-8 cursor-pointer"
						key={address.code}
						onClick={() => handleSelectAddress(address.address)}
					>
						<div className="col-span-2 flex items-center justify-center text-lg font-semibold bg-accent/20 border-r border-accent py-2 rounded-s-md">
							{address.code}
						</div>
						<div className="col-span-6 flex items-center justify-center text-center bg-field-bg rounded-e-md">
							{address.address}
						</div>
					</div>
				))}
			</div>
		</Modal>
	);
};
