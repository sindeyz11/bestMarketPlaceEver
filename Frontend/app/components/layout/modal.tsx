import React, { ReactNode, useEffect, useRef } from "react"
import ReactDOM from "react-dom"
import { CrossIcon } from "../icons/cross-icon"

interface ModalProps {
	isOpen: boolean
	onClose: () => void
	children: ReactNode
}

const Modal: React.FC<ModalProps> = ({ isOpen, onClose, children }) => {
	const modalRef = useRef<HTMLDivElement>(null)

	const handleClickOutside = (event: MouseEvent) => {
		if (modalRef.current && !modalRef.current.contains(event.target as Node)) {
			onClose()
		}
	}

	const handleKeyDown = (event: KeyboardEvent) => {
		if (event.key === "Escape") {
			onClose()
		}
	}

	useEffect(() => {
		if (isOpen) {
			document.body.style.overflow = "hidden"
			document.addEventListener("mousedown", handleClickOutside)
			document.addEventListener("keydown", handleKeyDown)
		} else {
			document.body.style.overflow = "auto"
			document.removeEventListener("mousedown", handleClickOutside)
			document.removeEventListener("keydown", handleKeyDown)
		}

		return () => {
			document.body.style.overflow = "auto"
			document.removeEventListener("mousedown", handleClickOutside)
			document.removeEventListener("keydown", handleKeyDown)
		}
	}, [isOpen])

	if (!isOpen) {
		return null
	}

	return ReactDOM.createPortal(
		<div className="fixed inset-0 z-50 flex items-center justify-center bg-black bg-opacity-50">
			<div
				ref={modalRef}
				className="relative bg-white p-6 rounded-xl shadow-lg max-w-2xl w-full"
			>
				<button
					className="absolute top-4 right-4 p-2 text-gray-500 hover:text-gray-800"
					onClick={onClose}
				>
					<CrossIcon className="h-4 w-4" />
				</button>
				{children}
			</div>
		</div>,
		document.body
	)
}

export default Modal
