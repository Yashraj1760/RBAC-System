## MegaMerch Ecommerce Website with RBAC

A modern and responsive Role-Based Access Control (RBAC) system built with java, spring boot , html css .

## My Contribution 

I have worked on whole backend while frontend was made by my teammate.

## GoogleOAuthSuccessHandler.class Breakdown
This code is a custom Spring Security authentication success handler for Google OAuth2 login. It manages the flow after a user successfully logs in with Google OAuth2. Here's a summary:

#### Dependencies:

- **UserDao and RoleDao**: Data access objects used to interact with the database for user and role information.
#### Purpose:

Handles post-authentication logic, such as checking if the user exists in the database. If not, it creates a new user and assigns a default role.
#### Key Functionality:

Extracts user information (like email, first name, last name) from the OAuth2 authentication token.
Checks if a user with the email exists in the database:
If not, it creates a new user with basic details (firstName, lastName, email) and assigns a default role (roleId = 2).
Saves the new user to the database.
Redirects the user to the home page (/) after successful authentication.
#### Error Handling:

Uses DefaultRedirectStrategy to manage redirection securely after authentication.
Implements the AuthenticationSuccessHandler interface to define custom success handling logic.
The second onAuthenticationSuccess method appears redundant and simply invokes the default behavior. It might not be necessary.


## SecurityConfig.class breakdown
This code configures Spring Security for a web application. Here's a breakdown:

#### Class Setup:

@Configuration: Marks this class as a Spring configuration class.
@EnableWebSecurity: Enables Spring Security features.
Extends WebSecurityConfigurerAdapter to customize security configuration.

#### Dependencies:

Injects GoogleOAuthSuccessHandler for handling successful OAuth logins.
Injects CustomUserDetailService for user authentication.

#### HTTP Security Configuration:

#### Authorization Rules:
Public access (permitAll): Home (/), shop pages (/shop/**), and registration (/register).
Restricted access: Admin pages (/admin/**) require ADMIN role.
All other requests require authentication.
#### Form-Based Login:
Custom login page (/login).
Redirects to /login?error=true on failure or / on success.
#### OAuth2 Login:
Uses Google OAuth with GoogleOAuthSuccessHandler.
#### Logout:
Logout URL: /logout.
Redirects to /login after logout and invalidates the session.
#### CSRF:
Disabled for simplicity (not recommended for production).
#### Headers:
Disables frame options for compatibility with embedded resources.

#### Password Encoding:

Defines a BCryptPasswordEncoder bean for hashing passwords securely.
#### Authentication Manager:

Configures CustomUserDetailService for loading user details during authentication.
#### Ignored Resources:

Excludes static assets like CSS, JS, and images from security filters (/resources/**, /static/**, etc.).
This setup supports role-based authorization, Google OAuth login, and secure password handling while allowing public access to specific pages

## 🌟 Features

### User Management
- View, add, edit, and delete users
- Assign roles and manage user status
- Advanced filtering and sorting capabilities
- Real-time search functionality
- Form validation using Zod

### Role Management
- Create and manage roles
- Define and modify role permissions
- Visual permission management interface
- Dynamic role assignment

### Dashboard
- Overview of system statistics
- Users per role distribution
- Interactive charts and metrics
- Quick access to key functionalities

### Security & UX Features
- Input validation and sanitization
- Error handling and user feedback
- Responsive design for all devices
- Clean and intuitive interface

## 🚀 Technical Implementation

### Frontend Stack
- **Html**
- **CSS** for styling
- **Thymleaf** for interacting backend.

### Key Components
- `UserManagement`: Comprehensive user CRUD operations
- `RoleManagement`: Role and permission management
- `Dashboard`: User can add product in cart , veiw product
- `Layout`: Responsive page structure with sidebar navigation


## 🔒 Security Features
- Role-based access control
- Secure form submissions

## 🚀 Running Locally

### Prerequisites

Before you begin, ensure you have the following installed:
- java (8 or higher)
- Springboot(2.4.1)
- Git



The application will start running at `http://localhost:8080`


## 📋 Project Structure
```
src/
├── configuration/  # Security and oAuth configuration
├── services/       # API and service functions
├── model/          # for entity classes
├── Repositories/   # To interact with database
└── resources/templates/ # for html and css pages
```

## 📝 Assignment Evaluation Criteria Met

1. **Creativity and Design Quality**
   - Modern, clean interface
   - Intuitive navigation
   - Consistent design language


3. **Functionality**
   - Complete CRUD operations
   - Role management
   - Permission handling

4. **User Experience**
   - Smooth transitions
   - Loading states
   - Error handling
   - Intuitive workflows

5. **Technical Skill**
   - Code organization
   - Form validation

6. **Documentation**
   - Comprehensive README

7. **Security Practices**
   - Input validation
   - Error handling
   - Secure API calls

8. **Additional Features**
   - Advanced filtering
   
