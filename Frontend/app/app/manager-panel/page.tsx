import { PickupPointsList } from "@/components/admin-panel/pickup-points-list";
import { PositionsList } from "@/components/admin-panel/positions-list";
import { UsersList } from "@/components/admin-panel/users-list";
import { IssuingOrder } from "@/components/manager-panel/issuing-order";
import { PickupPoint } from "@/components/manager-panel/pickup-point";
import authStore from "@/store/auth";

const AdminPanelPage = () => {
  return (
    <div
      style={{ minHeight: "calc(100dvh - 240px)" }}
      className="flex py-10 bg-[#F6F6F6]"
    >
      <div className="w-full grid grid-cols-3 px-20 gap-6 h-full">
        <div className="col-span-1">
          <PickupPoint point={authStore.getPickupPointByCode("000-001")} />
        </div>
        <div className="col-span-2">
          <IssuingOrder />
        </div>
      </div>
    </div>
  );
};

export default AdminPanelPage;
