var myapp = angular.module("myapp", []).controller(
		"BookController",
		function($scope, $http) {

			$scope.getBookList = function() {
				$http.get('http://localhost:8080/spring/getBookList').success(
						function(data) {
							$scope.books = data;
						})
			}

			$scope.addToCart = function(isbn) {
				$http
						.put(
								'http://localhost:8080/spring/cart/add/{isbn}'
										+ isbn).success(function() {
							alert('Item Successfully added to the cart!');
						})
			}
			$scope.refreshCart = function() {
				$http.get(
						'http://localhost:8080/spring/cart/getCart/'
								+ $scope.cartId).success(function(data) {
					$scope.cart = data;
				})
			}
			$scope.getCart = function(cartId) {
				$scope.cartId = cartId;
				$scope.refreshCart(cartId);
			}

			$scope.removeFromCart = function(cartItemId) {
				$http.put(
						'http://localhost:8080/spring/cart/removecartitem/'
								+ cartItemId).success(function() {
					$scope.refreshCart();
				})
			}

			$scope.clearCart = function() {
				$http.put(
						'http://localhost:8080/spring/cart/removeAllItems/'
								+ $scope.cartId).success(function() {
					$scope.refreshCart();
				});
			}

			$scope.calculateGrandTotal = function() {
				alert("Welcome to Cart");
				var grandTotal = 0.0
				for (var i = 0; i < $scope.cart.cartItem.length; i++)
					grandTotal = grandTotal
							+ $scope.cart.cartItem[i].totalprice;
				return grandTotal;
			}
		});
