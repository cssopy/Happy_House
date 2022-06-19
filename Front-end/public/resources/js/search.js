dong.addEventListener('change', () => {
	if (dong.value !== '동을 선택하세요.') {
		window.location.href = `/aptSearch/searchByDong?dong=${dong.value}`;
	}
});