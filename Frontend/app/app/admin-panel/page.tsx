import { PickupPointsList } from "@/components/admin-panel/pickup-points-list"
import { PositionsList } from "@/components/admin-panel/positions-list"
import { Users } from "@/components/admin-panel/users"
import authStore from "@/store/auth"

const AdminPanelPage = () => {
	return (
		<div
			style={{ minHeight: "calc(100dvh - 240px)" }}
			className="flex py-10 bg-[#F6F6F6]"
		>
			<div className="w-full grid grid-cols-3 px-20 gap-6">
				<PositionsList positions={authStore.productsAdmin} />
				<PickupPointsList />
				<Users />
			</div>
		</div>
	)
}

export default AdminPanelPage
